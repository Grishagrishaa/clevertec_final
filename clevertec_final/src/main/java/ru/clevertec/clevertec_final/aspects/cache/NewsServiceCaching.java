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
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;

import java.util.UUID;

/**
 * Aspect class for caching NewsService method results.
 */
@Aspect
@Component
@Profile("dev")
@RequiredArgsConstructor
public class NewsServiceCaching {
    private final Cache<UUID, NewsReadDto> newsCache;

    /**
     * Retrieves the result from the cache if available, otherwise executes the method and caches the result.
     *
     * @param pjp  the ProceedingJoinPoint object representing the method being intercepted
     * @param uuid the UUID argument of the method
     * @return the result from the cache or the executed method
     * @throws Throwable if an error occurs during method execution
     */
    @Around(value = "isCacheableNewsServiceMethod() && args(uuid, ..)")
    public Object getFromCache(ProceedingJoinPoint pjp, UUID uuid) throws Throwable {
        if (newsCache.get(uuid).isPresent()) {
            return newsCache.get(uuid).get();
        } else {
            NewsReadDto newsReadDto = (NewsReadDto) pjp.proceed();
            return newsCache.put(uuid, newsReadDto);
        }
    }

    /**
     * Puts the returned NewsReadDto object in the cache after a method with @CachePut annotation is executed.
     *
     * @param retNews the returned NewsReadDto object from the method
     */
    @AfterReturning(value = "isCachePutNewsServiceMethod()", returning = "retNews")
    public void putInCache(Object retNews) {
        NewsReadDto news = (NewsReadDto) retNews;
        newsCache.put(news.getUuid(), news);
    }

    /**
     * Deletes the entry from the cache when a method with @CacheEvict annotation is executed.
     *
     * @param uuid the UUID argument of the method
     */
    @After(value = "isCacheEvictNewsServiceMethod() && args(uuid, ..)", argNames = "uuid")
    public void deleteFromCache(UUID uuid) {
        newsCache.remove(uuid);
    }

    /**
     * Pointcut definition for methods in NewsServiceImpl class annotated with @Cacheable.
     */
    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheableAnnotation() && isNewsServiceMethods()")
    public void isCacheableNewsServiceMethod() {
    }

    /**
     * Pointcut definition for methods in NewsServiceImpl class annotated with @CachePut.
     */
    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCachePutAnnotation() && isNewsServiceMethods()")
    private void isCachePutNewsServiceMethod() {
    }

    /**
     * Pointcut definition for methods in NewsServiceImpl class annotated with @CacheEvict.
     */
    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheEvictAnnotation() && isNewsServiceMethods()")
    private void isCacheEvictNewsServiceMethod() {
    }

    /**
     * Pointcut definition for methods in NewsServiceImpl class.
     */
    @Pointcut("within(ru.clevertec.clevertec_final.service.impl.NewsServiceImpl)")
    public void isNewsServiceMethods() {
    }
}

