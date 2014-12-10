package com.github.dekobon;

import javax.inject.Singleton;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;

@Singleton
public class SharedState {
    AtomicReference<Instant> lastAccessed = new AtomicReference<>(Instant.now());

    @Override
    public String toString() {
        return String.format("Shared state last accessed: %s",
                lastAccessed.getAndSet(Instant.now()));
    }
}
