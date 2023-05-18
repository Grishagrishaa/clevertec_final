package ru.clevertec.clevertec_final.unit.cache.impl.lruCache;

import org.junit.jupiter.api.Test;
import ru.clevertec.clevertec_final.cache.Cache;
import ru.clevertec.clevertec_final.cache.impl.lfuCache.CacheLFUImpl;
import ru.clevertec.clevertec_final.cache.impl.lruCache.CacheLRUImpl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheLRUImplTest {

    @Test
    public void putDataShouldNotEvictLeastRecentlyData() {
        Cache<String, String> lruCache = new CacheLRUImpl<>(3);
        lruCache.put("1", "test1");
        lruCache.put("2", "test2");
        lruCache.put("3", "test3");

        assertThat("test1").isEqualTo(lruCache.get("1").get());
        assertThat("test2").isEqualTo( lruCache.get("2").get());
        assertThat("test3").isEqualTo(lruCache.get("3").get());
    }

    @Test
    public void putDataShouldEvictLeastRecentlyData() {
        Cache<String, String> lruCache = new CacheLRUImpl<>(3);
        lruCache.put("1", "test1");
        lruCache.put("2", "test2");
        lruCache.put("3", "test3");
        lruCache.put("4", "test4");

        assertThat(lruCache.get("1")).isNotPresent();
    }
}