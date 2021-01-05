package io.github.katurkmen.tweetconsumer.tweet;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {

    @JsonProperty("created_at")
    String date;

    @JsonProperty("id_str")
    String username;

    @JsonProperty("text")
    String tweetContent;

    public Tweet(String date, String username, String tweetContent) {
        this.date = date;
        this.username = username;
        this.tweetContent = tweetContent;
    }

    public Tweet() {
    }


    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "date='" + date + '\'' +
                ", username='" + username + '\'' +
                ", tweetContent='" + tweetContent + '\'' +
                '}';
    }
}
