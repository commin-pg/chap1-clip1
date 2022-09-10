package com.fastcampus.chap1clip1.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clip3-id", topics = "clip3")
    public void clip3(String message){
        System.out.println("Consumer : " + message);
    }


    @KafkaListener(id = "clip3-idBytes", topics = "clip3-bytes")
    public void clip3_bytes(String message){
        System.out.println("Consumer : " + message);
    }

    @KafkaListener(id = "clip3-request-id", topics = "clip3-request")
    @SendTo
    public String clip3_request(String message){
        System.out.println("Consumer : " + message);
        return "Pong Clip3";
    }
}
