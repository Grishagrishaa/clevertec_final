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

    @Around(value = "isCacheableCommentServiceMethod() && args(uuid,..)", argNames = "pjp,uuid")
    public Object getFromCache(ProceedingJoinPoint pjp, UUID uuid) throws Throwable {

        if(commentCache.get(uuid).isPresent()){
            return commentCache.get(uuid).get();
        } else {
            CommentReadDto commentReadDto = (CommentReadDto) pjp.proceed();
            return commentCache.put(uuid, commentReadDto);
        }

    }

    @AfterReturning(value = "isCachePutCommentServiceMethod()", returning = "retSaleCard")
    public void putInCache(Object retSaleCard) {
        CommentReadDto comment = (CommentReadDto) retSaleCard;
        commentCache.put(comment.getUuid(), comment);
    }

    @After(value = "isCacheEvictCommentServiceMethod() && args(uuid,..)", argNames = "uuid")
    public void deleteFromCache(UUID uuid) {
        commentCache.remove(uuid);
    }


    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheableAnnotation() && isCommentServiceMethods())")
    public void isCacheableCommentServiceMethod(){
    }

    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCachePutAnnotation() && isCommentServiceMethods()")
    private void isCachePutCommentServiceMethod() {
    }

    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheEvictAnnotation() && isCommentServiceMethods())")
    private void isCacheEvictCommentServiceMethod() {
    }

    @Pointcut("within(ru.clevertec.clevertec_final.service.impl.CommentServiceImpl)")
    public void isCommentServiceMethods(){
    }

}
