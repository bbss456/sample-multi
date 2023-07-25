package com.example.kafka.controller;

import com.example.kafka.dto.RequestMemberDTO;
import com.example.kafka.dto.RequestMessageDTO;
import com.example.kafka.producer.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

@Tag(name = "Kafka 전송", description = "Kafka 토픽 Send api 입니다.")
@RestController
@RequestMapping("api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {
    public HttpHeaders header() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return  header;
    }

    private final KafkaProducerService kafkaProducerService;

    @Operation(summary = "메세지 전송", description = "프로듀서 메세지 전송")
    @PostMapping("/message")
    public ResponseEntity<Boolean> sendMessage(@RequestBody RequestMessageDTO requestMessageDTO) {
        System.out.println(requestMessageDTO.getMessage());

       return new  ResponseEntity<Boolean>(kafkaProducerService.sendMessage(requestMessageDTO.getMessage()), this.header() ,HttpStatus.ACCEPTED);
    }

    @Operation(summary = "멤버 전송", description = "프로듀서 멤버 전송")
    @PostMapping("/member")
    public ResponseEntity<Boolean> sendMember(@RequestBody RequestMemberDTO requestMemberDTO) throws JsonProcessingException {

        return new  ResponseEntity<Boolean>(kafkaProducerService.sendMemberMessage(requestMemberDTO), this.header() ,HttpStatus.ACCEPTED);
    }

}
