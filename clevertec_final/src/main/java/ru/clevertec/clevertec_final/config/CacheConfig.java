package ru.clevertec.clevertec_final.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import ru.clevertec.clevertec_final.cache.Cache;
import ru.clevertec.clevertec_final.cache.util.CacheFactory;
import ru.clevertec.clevertec_final.cache.util.enums.ECacheType;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;

import java.time.Duration;
import java.util.UUID;


@Configuration
public class CacheConfig {
    @Value("${app.cache.size}")
    private Integer size;
    @Value("#{'${app.cache.type}'.toUpperCase()}")
    private ECacheType cacheType;

    private final CacheFactory cacheFactory;

    public CacheConfig(CacheFactory cacheFactory) {
        this.cacheFactory = cacheFactory;
    }

    @Bean
    @Profile("dev")
    public Cache<UUID, NewsReadDto> newsCache(){
        return cacheFactory.getCache(size, cacheType);
    }

    @Bean
    @Profile("dev")
    public Cache<UUID, CommentReadDto> commentCache(){
        return cacheFactory.getCache(size, cacheType);
    }

    @Bean
    @Profile("prod")
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(60)) // установка времени жизни записей в кеше
                .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();
    }

    @Bean
    @Profile("prod")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return template;
    }
}
