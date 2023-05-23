package com.example.redis;

import com.example.redis.redis.entity.ResultHistory;
import com.example.redis.redis.repository.ResultRedisRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
//@Slf4j
public class test {
    @Autowired
    private ResultRedisRepository redisRepository;

//    @AfterEach
//    void afterAll() {
//        redisRepository.deleteAll();
//    }

    @Autowired
    private RedisTemplate redisTemplate;
//
//    // 데이터 넣기

    @Test
    public void setValues(){
        String name = "황현수";
        String age = "20";

        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(name, age, Duration.ofMinutes(20)); // 1분 뒤 메모리에서 삭제된다.
    }

    @Test
    @Rollback(value = false)
    void save() throws Exception {
        // given
        ResultHistory result = ResultHistory.builder()
                .ip("127.0.0.1")
                .originalText("안녕하세요.")
                .translatedText("he2llo")
                .createDateTime(LocalDateTime.now())
                .build();

        // when
        ResultHistory save = redisRepository.save(result);

        // then
        ResultHistory find = redisRepository.findById(save.getId()).get();
        System.out.println("id:" +  find.getIp());
        System.out.println("original text:" +  find.getOriginalText());
        System.out.println("translated text: " + find.getTranslatedText());
//        log.info("id: {}", find.getId());
//        log.info("original text: {}", find.getOriginalText());
//        log.info("translated text: {}", find.getTranslatedText());

        Assertions.assertThat(save.getIp()).isEqualTo(find.getIp());
        Assertions.assertThat(save.getOriginalText()).isEqualTo(find.getOriginalText());
        Assertions.assertThat(save.getTranslatedText()).isEqualTo(find.getTranslatedText());
    }

    @Test
    void save_multi() throws Exception {
        // given
        ResultHistory rst1 = ResultHistory.builder()
                .ip("127.0.0.1")
                .originalText("안녕하세요.")
                .translatedText("hello")
                .createDateTime(LocalDateTime.now())
                .build();

        ResultHistory rst2 = ResultHistory.builder()
                .ip("127.0.0.1")
                .originalText("반갑습니다.")
                .translatedText("Nice to meet you.")
                .createDateTime(LocalDateTime.now())
                .build();

        ResultHistory rst3 = ResultHistory.builder()
                .ip("127.1.1.1")
                .originalText("반갑습니다.")
                .translatedText("Nice to meet you.")
                .createDateTime(LocalDateTime.now())
                .build();

        // when
        redisRepository.save(rst1);
        redisRepository.save(rst2);
        redisRepository.save(rst3);

        // then
        List<ResultHistory> results = redisRepository.findByIpOrderByCreateDateTimeAsc("127.0.0.1").get();
        Assertions.assertThat(results.size()).isEqualTo(2);
    }

    @Test
    void search_order_by() throws Exception {
        // given
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ResultHistory rst1 = ResultHistory.builder()
                .ip("127.0.0.1")
                .originalText("안녕하세요.")
                .translatedText("hello")
                .createDateTime(LocalDateTime.parse("2023-01-05 20:20:20", dateTimeFormatter))
                .build();

        ResultHistory rst2 = ResultHistory.builder()
                .ip("127.0.0.1")
                .originalText("반갑습니다.")
                .translatedText("Nice to meet you.")
                .createDateTime(LocalDateTime.parse("2023-01-05 20:21:20", dateTimeFormatter))
                .build();

        ResultHistory rst3 = ResultHistory.builder()
                .ip("127.0.0.1")
                .originalText("반갑습니다.")
                .translatedText("Nice to meet you.")
                .createDateTime(LocalDateTime.parse("2023-01-05 20:22:20", dateTimeFormatter))
                .build();

        // when
        redisRepository.save(rst1);
        redisRepository.save(rst2);
        redisRepository.save(rst3);

        // then
        List<ResultHistory> results = redisRepository.findByIpOrderByCreateDateTimeAsc("127.0.0.1").get();
        Assertions.assertThat(results.get(0).getCreateDateTime()).isEqualTo(LocalDateTime.parse("2023-01-05 20:20:20", dateTimeFormatter));
    }
}

