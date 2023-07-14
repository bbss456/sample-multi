package com.example.kafka.producer;

import com.example.kafka.dto.RequestMemberDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private static final String TOPIC = "member_topic2";
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public Boolean sendMessage(String message) {
        log.info("Produce message : %s",message);

        this.kafkaTemplate.send(TOPIC, message);

        return Boolean.TRUE;
    }

    public Boolean sendMemberMessage(RequestMemberDTO requestMemberDTO) throws JsonProcessingException {
        log.info("Produce Member Name : %s", requestMemberDTO.getName());

        String record = mapper.writeValueAsString(requestMemberDTO);
        this.kafkaTemplate.send(TOPIC, record);

        return Boolean.TRUE;
    }

}
