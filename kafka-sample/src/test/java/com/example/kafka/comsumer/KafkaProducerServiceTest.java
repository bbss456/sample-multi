package com.example.kafka.comsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class KafkaProducerServiceTest {

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void sendMessage() {
        String TOPIC = "my_topic2";
        String message = "sendTest";
        System.out.println(String.format("Produce message : %s", message));
        this.kafkaTemplate.send(TOPIC, message);


        assertEquals("a","a");
    }
}