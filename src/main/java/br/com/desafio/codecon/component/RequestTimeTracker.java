package br.com.desafio.codecon.component;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RequestTimeTracker {

    private static final ThreadLocal<Instant> startTime = new ThreadLocal<>();

    public void start() {
        startTime.set(Instant.now());
    }

    public Instant getStartTime() {
        return startTime.get();
    }

    public void clear() {
        startTime.remove();
    }

}
