package com.ink.redis.poc;

public class Increment {
    public String key;
    public long value;

    public Increment(String key, long value) {
        this.key = key;
        this.value = value;
    }

    public Increment() {
    }
}
