package ru.clevertec.clevertec_final.cache.util;

import org.springframework.stereotype.Component;
import ru.clevertec.clevertec_final.cache.Cache;
import ru.clevertec.clevertec_final.cache.util.enums.ECacheType;
import ru.clevertec.clevertec_final.cache.impl.lfuCache.CacheLFUImpl;
import ru.clevertec.clevertec_final.cache.impl.lruCache.CacheLRUImpl;

/**
 * Factory class for creating caches based on the specified cache type.
 */
@Component
public class CacheFactory {

    /**
     * Creates a cache based on the specified cache size and cache type.
     *
     * @param size      the size of the cache
     * @param cacheType the cache type
     * @param <K>       the type of the cache keys
     * @param <V>       the type of the cache values
     * @return a cache instance based on the specified cache type
     */
    public <K, V> Cache<K, V> getCache(Integer size, ECacheType cacheType) {
        return switch (cacheType) {
            case LFU -> new CacheLFUImpl<>(size);
            case LRU -> new CacheLRUImpl<>(size);
        };
    }
}

