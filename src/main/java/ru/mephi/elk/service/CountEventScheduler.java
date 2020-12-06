package ru.mephi.elk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mephi.elk.dto.ObjectCountDto;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
public class CountEventScheduler {

    private final CountEventService countEventService;
    private final LogstashService logstashService;

    private final String TWIT_COUNT = "twitCount";

    @Scheduled(fixedDelayString = "${log.count.period}")
    public void logTwitCount() {
        Long count = countEventService.getAndResetTwitCount();
        ObjectCountDto objectCount = new ObjectCountDto(TWIT_COUNT, count);
        logstashService.sendObjectCount(objectCount);
        log.info("Name: {}, count : {}", TWIT_COUNT, count);
    }

}
