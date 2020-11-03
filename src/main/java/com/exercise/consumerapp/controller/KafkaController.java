package com.exercise.consumerapp.controller;

import com.exercise.consumerapp.consumer.MyTopicConsumer;
import com.exercise.consumerapp.models.KafkaMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private MyTopicConsumer myTopicConsumer;
    public KafkaController(MyTopicConsumer myTopicConsumer) {
        this.myTopicConsumer = myTopicConsumer;
    }
    @GetMapping("/kafka/messages")
    public List<KafkaMessage> getMessages() {
        return myTopicConsumer.getMessages();
    }

}
