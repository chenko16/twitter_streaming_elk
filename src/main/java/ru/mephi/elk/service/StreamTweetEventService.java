package ru.mephi.elk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class StreamTweetEventService {

    private final Twitter twitter;
    private final StreamListener onTwitListener;

    /**
     * Start consuming from stream
     */
    @PostConstruct
    public void streamTweetEvent() {
        // this will open the stream
        twitter.streamingOperations().sample(Arrays.asList(onTwitListener));
    }

}
