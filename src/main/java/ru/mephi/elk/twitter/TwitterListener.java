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

    @Override
    public void onTweet(Tweet tweet) {
        countEventService.incrementTwitCount();
    }

    @Override
    public void onDelete(StreamDeleteEvent streamDeleteEvent) {

    }

    @Override
    public void onLimit(int i) {

    }

    @Override
    public void onWarning(StreamWarningEvent streamWarningEvent) {

    }
}
