package com.example.kafka.comsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;



class SampleTest {


    @Test
    public void sampleTest() {
        String[] strings = "18!@29!@SM!@2023-06-15!@false!@group_001!@e1110!@643!@0!@0!@0!@1!@0".split("!@");

        System.out.println("asd|asd");
        String test = "hellow";
        System.out.println(test);
        System.out.println(test.substring(test.length()-1));

        if(strings[strings.length-1].equals("0")) {


            System.out.println("asd");
        }

    }

}