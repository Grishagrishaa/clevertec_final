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

@Aspect
@Component
@Profile("dev")
@RequiredArgsConstructor
public class NewsServiceCaching {
    private final Cache<UUID, NewsReadDto> newsCache;

    @Around(value = "isCacheableNewsServiceMethod()  && args(uuid,..)")
    public Object getFromCache(ProceedingJoinPoint pjp, UUID uuid) throws Throwable {

        if(newsCache.get(uuid).isPresent()){
            return newsCache.get(uuid).get();
        } else {
            NewsReadDto newsReadDto = (NewsReadDto) pjp.proceed();
            return newsCache.put(uuid, newsReadDto);
        }

    }

    @AfterReturning(value = "isCachePutNewsServiceMethod()", returning = "retNews")
    public void putInCache(Object retNews) {
        NewsReadDto news = (NewsReadDto) retNews;
        newsCache.put(news.getUuid(), news);
    }

    @After(value = "isCacheEvictNewsServiceMethod() && args(uuid,..)", argNames = "uuid")
    public void deleteFromCache(UUID uuid) {
        newsCache.remove(uuid);
    }

    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheableAnnotation() && isNewsServiceMethods())")
    public void isCacheableNewsServiceMethod(){
    }


    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCachePutAnnotation() && isNewsServiceMethods()")
    private void isCachePutNewsServiceMethod() {
    }

    @Pointcut("ru.clevertec.clevertec_final.aspects.Pointcuts.hasCacheEvictAnnotation() && isNewsServiceMethods())")
    private void isCacheEvictNewsServiceMethod() {
    }

    @Pointcut("within(ru.clevertec.clevertec_final.service.impl.NewsServiceImpl)")
    public void isNewsServiceMethods(){
    }

}
