package com.example.kafkaex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;


import java.time.LocalDateTime;

@Slf4j
@Service
public class TestService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String insert(){
        String currentTime = LocalDateTime.now().toString();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("currentTime", currentTime);
        future.addCallback(successCallback -> {
            log.info("[producer] successCallback.offset: " + successCallback.getRecordMetadata().offset());
        },
            errorCallback ->{
                log.error("[producer] errorCallback msg: " + errorCallback.getMessage());
            }
        );
        return "insert current time : {}".format(currentTime);
    }
}
