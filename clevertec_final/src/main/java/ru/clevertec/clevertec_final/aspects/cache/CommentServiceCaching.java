package ru.clevertec.clevertec_final.aspects.cache;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.clevertec.clevertec_final.cache.Cache;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;

import java.util.UUID;


@Aspect
@Component
@Profile("dev")
@RequiredArgsConstructor
public class CommentServiceCaching {
    private final Cache<UUID, CommentReadDto> commentCache;

    /**
     * Retrieves the result from the cache if available, otherwise executes the method and caches the result.
     *
     * @param pjp  the ProceedingJoinPoint object representing the method being intercepted
     * @param uuid the UUID argument of the method
     * @return the result from the cache or the executed method
     * @throws Throwable if an error occurs during method execution
     */
    @Around(value = "isCacheableCommentServiceMethod() && args(uuid, ..)", argNames = "pjp, uuid")
    public Object getFromCache(ProceedingJoinPoint pjp, UUID uuid) throws Throwable {
        if (commentCache.get(uuid).isPresent()) {
            return commentCache.get(uuid).get();
        } else {
            CommentReadDto commentReadDto = (CommentReadDto) pjp.proceed();
            return commentCache.put(uuid, commentReadDto);
        }
    }

    /**
     * Puts the returned CommentReadDto object in the cache after a method with @CachePut annotation is executed.
     *
     * @param retSaleCard the returned CommentReadDto object from the method
     */
    @AfterReturning(value = "isCachePutCommentServiceMethod()", returning = "retSaleCard")
    public void putInCache(Object retSaleCard) {
        CommentReadDto comment = (CommentReadDto) retSaleCard;
        commentCache.put(comment.getUuid(), comment);
    }

    /**
     * Deletes the entry from the cache when a method with @CacheEvict annotation is executed.
     *
     * @param uuid the UUID argument of the method
     */
    @After(value = "isCacheEvictCommentServiceMethod() && args(uuid, ..)", argNames = "uuid")
    public void deleteFromCache(UUID uuid) {
        commentCache.remove(uuid);
    }

    /**
     * Pointcut definition for methods in CommentServiceImpl class annotated with @Cacheable.
     */
    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheableAnnotation() && isCommentServiceMethods()")
    public void isCacheableCommentServiceMethod() {
    }

    /**
     * Pointcut definition for methods in CommentServiceImpl class annotated with @CachePut.
     */
    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCachePutAnnotation() && isCommentServiceMethods()")
    private void isCachePutCommentServiceMethod() {
    }

    /**
     * Pointcut definition for methods in CommentServiceImpl class annotated with @CacheEvict.
     */
    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheEvictAnnotation() && isCommentServiceMethods()")
    private void isCacheEvictCommentServiceMethod() {
    }

    /**
     * Pointcut definition for methods in CommentServiceImpl class.
     */
    @Pointcut("within(ru.clevertec.clevertec_final.service.impl.CommentServiceImpl)")
    public void isCommentServiceMethods() {
    }
}
