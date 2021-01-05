package io.github.katurkmen.tweetconsumer;

import io.github.katurkmen.tweetconsumer.tweet.Tweet;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, Tweet> tweetConsumerFactory() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "tweet-producer");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new org.springframework.kafka.support.serializer.JsonDeserializer<>(Tweet.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Tweet> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Tweet> kafkaListenerContainerFactory= new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(tweetConsumerFactory());
        return kafkaListenerContainerFactory;
    }
}
