package ru.mephi.elk.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CountEventService {

    private AtomicLong twitCount = new AtomicLong(0);

    /**
     * Increment tweets count
     */
    public void incrementTwitCount() {
        twitCount.incrementAndGet();
    }

    /**
     * Return and reset tweets count
     * @return tweets count
     */
    public Long getAndResetTwitCount() {
        Long count = twitCount.get();
        twitCount.set(0);
        return count;
    }
}
