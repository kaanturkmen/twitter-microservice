package io.github.katurkmen.tweetconsumer.tweet;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TweetDaoService {
    private static List<Tweet> tweets = new ArrayList<>();

    public List<Tweet> findAll() {
        return tweets;
    }

    @KafkaListener(topics = "twitter_consumer", containerFactory = "kafkaListenerContainerFactory")
    public void consumeMessage(Tweet tweet){
        tweets.add(tweet);
    }
}
