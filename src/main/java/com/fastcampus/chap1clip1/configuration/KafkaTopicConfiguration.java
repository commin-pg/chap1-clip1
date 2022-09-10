package com.fastcampus.chap1clip1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicConfiguration {

    @Bean
    public KafkaAdmin.NewTopics clip3s(){
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("clip3").build(),
                TopicBuilder.name("clip3-bytes").build(),
                TopicBuilder.name("clip3-request").build(),
                TopicBuilder.name("clip3-replies").build()

        );
    }


}
