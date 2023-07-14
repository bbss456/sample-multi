package com.example.kafka.comsumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class KafkaComsumerService {

    @KafkaListener(topics = "member_topic", groupId = "member_topic")
    public Boolean consume(String message) throws IOException {
        log.info(String.format("receive message %s", message));

        return Boolean.TRUE;
    }
}
