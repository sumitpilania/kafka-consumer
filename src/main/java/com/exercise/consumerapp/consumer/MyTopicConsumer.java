package com.exercise.consumerapp.consumer;

import com.exercise.consumerapp.models.KafkaMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MyTopicConsumer.class.getName());
    private final List<KafkaMessage> messages = new ArrayList<>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(String message) {
        synchronized (messages) {
            logger.info(message);
            ObjectMapper mapper = new ObjectMapper();
            KafkaMessage kafkaMessage = null;
            try {
                kafkaMessage = mapper.readValue(message, KafkaMessage.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            logger.info("Kafka Message object is : "+kafkaMessage);
            messages.add(kafkaMessage);
        }
    }
    public List<KafkaMessage> getMessages() {
        return messages;
    }
}
