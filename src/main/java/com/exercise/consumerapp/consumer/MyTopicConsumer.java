package com.exercise.consumerapp.consumer;

import com.exercise.consumerapp.models.DataSchema;
import com.exercise.consumerapp.models.KafkaMessage;
import com.exercise.consumerapp.service.DataConversionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTopicConsumer {

    @Autowired
    DataConversionService dataConversionService;
    private static final Logger logger = LoggerFactory.getLogger(MyTopicConsumer.class.getName());
    private final List<DataSchema> messages = new ArrayList<DataSchema>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(String message) {

        synchronized (messages) {
            logger.info(message);
            ObjectMapper mapper = new ObjectMapper();
            KafkaMessage kafkaMessage = null;
            DataSchema dataSchema = null;
            try {
                //kafkaMessage = mapper.readValue(message, KafkaMessage.class);
                dataSchema = mapper.readValue(message, DataSchema.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            logger.info("Kafka Data Message received is : "+dataSchema);
            logger.info("Kafka Data Message after conversion is : "+dataConversionService. convertData(dataSchema));
            //messages.add(dataSchema); //List will overFlow
        }
    }
    public List<DataSchema> getMessages() {
        return messages;
    }
}
