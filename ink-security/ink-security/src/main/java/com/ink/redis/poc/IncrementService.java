package com.ink.redis.poc;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class IncrementService {

    // This quickstart demonstrates both the imperative
    // and reactive Redis data sources
    // Regular applications will pick one of them.

    private ReactiveKeyCommands<String> keyCommands;
    private ValueCommands<String, Long> countCommands;

    public IncrementService(RedisDataSource ds, ReactiveRedisDataSource reactive) {
        countCommands = ds.value(Long.class);
        keyCommands = reactive.key();

    }


    long get(String key) {
        Long value = countCommands.get(key);
        if (value == null) {
            return 0L;
        }
        return value;
    }

    void set(String key, Long value) {
        countCommands.set(key, value);
    }

    void increment(String key, Long incrementBy) {
        countCommands.incrby(key, incrementBy);
    }

    Uni<Void> del(String key) {
        return keyCommands.del(key)
                .replaceWithVoid();
    }

    Uni<List<String>> keys() {
        return keyCommands.keys("*");
    }
}
