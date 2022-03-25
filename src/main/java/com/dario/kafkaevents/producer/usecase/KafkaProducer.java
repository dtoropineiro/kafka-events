package com.dario.kafkaevents.producer.usecase;

public interface KafkaProducer {
  void sendMessage(String message);
}
