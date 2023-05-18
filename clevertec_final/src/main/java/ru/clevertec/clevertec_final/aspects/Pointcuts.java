package ru.clevertec.clevertec_final.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Profile("dev")
public class Pointcuts {

    /*
        Check Cacheable annotation
     */
    @Pointcut("@annotation(org.springframework.cache.annotation.Cacheable)")
    public void hasCacheableAnnotation(){
    }

    /*
            Check CachePut annotation
    */
    @Pointcut("@annotation(org.springframework.cache.annotation.CachePut)")
    public void hasCachePutAnnotation() {
    }


    /*
            Check CacheEvict annotation
    */
    @Pointcut("@annotation(org.springframework.cache.annotation.CacheEvict)")
    public void hasCacheEvictAnnotation() {
    }

}
