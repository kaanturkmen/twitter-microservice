package io.github.katurkmen.tweetconsumer.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetResource {

    @Autowired
    private TweetDaoService service;

    @GetMapping("/tweets")
    public List<Tweet> retrieveAllTweets() {
        return service.findAll();
    }
}
