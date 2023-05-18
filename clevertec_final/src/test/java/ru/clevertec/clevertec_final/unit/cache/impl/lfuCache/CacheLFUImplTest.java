package ru.clevertec.clevertec_final.unit.cache.impl.lfuCache;

import ru.clevertec.clevertec_final.cache.Cache;
import org.junit.jupiter.api.Test;
import ru.clevertec.clevertec_final.cache.impl.lfuCache.CacheLFUImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CacheLFUImplTest {

    @Test
    void putShouldReturnFalseWhenCapacityIsZero() {
        Cache<Long, String> cache = new CacheLFUImpl<>(0);
        String expected = "Some-value";
        String actual = cache.put(1L, expected);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void putShouldUpdateWhenKeyIsPresent() {
        Cache<Long, String> cache = new CacheLFUImpl<>(2);
        cache.put(1L, "Some-value-1");
        cache.put(1L, "New-value-1");

        assertThat("New-value-1").isEqualTo(cache.get(1L).get());
    }

    @Test
    void putShouldEvictValue() {
        Cache<Long, String> cache = new CacheLFUImpl<>(2);
        cache.put(1L, "Some-value-1");
        cache.put(2L, "Some-value-2");
        cache.get(2L);
        cache.get(2L);
        cache.put(3L, "Some-value-3");

        assertThat(cache.get(1L)).isEmpty();
    }

    @Test
    void removeShouldRemoveEntry() {
        Cache<Long, String> cache = new CacheLFUImpl<>(2);
        cache.put(1L, "Some-value-1");
        cache.put(2L, "Some-value-2");
        cache.get(1L);
        cache.remove(2L);

        assertThat(cache.get(2L)).isEmpty();    }
}