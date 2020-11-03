package com.exercise.consumerapp.models;

public class KafkaMessage {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
