package com.example.kafkaex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class TestController {

    @Autowired
    KafkaProducer service;

    @GetMapping("/insert")
    public String insert(){
        return service.insert();
    }

    @PostMapping("/sendmsg")
    public void sendMessage(String message){
        this.service.sendMessage(message);
    }
}
