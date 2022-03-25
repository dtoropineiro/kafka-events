package com.dario.kafkaevents.service;

public interface KafkaService {
  void sendMessage(String message);
}
