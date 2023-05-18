package ru.clevertec.clevertec_final.cache.util;

import org.springframework.stereotype.Component;
import ru.clevertec.clevertec_final.cache.Cache;
import ru.clevertec.clevertec_final.cache.util.enums.ECacheType;
import ru.clevertec.clevertec_final.cache.impl.lfuCache.CacheLFUImpl;
import ru.clevertec.clevertec_final.cache.impl.lruCache.CacheLRUImpl;

@Component
public class CacheFactory {
    public<K, V> Cache<K, V> getCache(Integer size, ECacheType ECacheType){
        return switch (ECacheType) {
            case LFU -> new CacheLFUImpl<>(size);
            case LRU -> new CacheLRUImpl<>(size);
        };
    }
}
