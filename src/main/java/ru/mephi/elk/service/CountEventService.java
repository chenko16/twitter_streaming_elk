package ru.mephi.elk.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CountEventService {

    private AtomicLong twitCount = new AtomicLong(0);

    public void incrementTwitCount() {
        twitCount.incrementAndGet();
    }

    public Long getAndResetTwitCount() {
        Long count = twitCount.get();
        twitCount.set(0);
        return count;
    }
}
