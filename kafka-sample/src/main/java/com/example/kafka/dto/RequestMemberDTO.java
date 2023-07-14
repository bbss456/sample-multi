package com.example.kafka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "멤버 정보 요청")
public class RequestMemberDTO {
    private String id;
    private String name;
    private String age;
}
