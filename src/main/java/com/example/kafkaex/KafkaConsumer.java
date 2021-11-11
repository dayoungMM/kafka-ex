package com.example.kafkaex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics ="currenttime", groupId="myGroup1")
    public void consume(String message) throws IOException{
        log.info("[consumer] Consumed message: {}", message);
    }
}
