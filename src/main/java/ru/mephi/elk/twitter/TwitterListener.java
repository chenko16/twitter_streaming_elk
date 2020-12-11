package ru.mephi.elk.twitter;

import lombok.RequiredArgsConstructor;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;
import ru.mephi.elk.service.CountEventService;

@Service
@RequiredArgsConstructor
public class TwitterListener implements StreamListener {

    private final CountEventService countEventService;

    /**
     * Processing of new tweet event
     * @param tweet tweet information
     */
    @Override
    public void onTweet(Tweet tweet) {
        countEventService.incrementTwitCount();
    }

    /**
     * Processing of delete event
     * @param streamDeleteEvent streamDeleteEvent information
     */
    @Override
    public void onDelete(StreamDeleteEvent streamDeleteEvent) {

    }

    /**
     * Processing of reaching limit event
     * @param i limit
     */
    @Override
    public void onLimit(int i) {

    }

    /**
     * Processing of warning event
     * @param streamWarningEvent streamWarningEvent information
     */
    @Override
    public void onWarning(StreamWarningEvent streamWarningEvent) {

    }
}
