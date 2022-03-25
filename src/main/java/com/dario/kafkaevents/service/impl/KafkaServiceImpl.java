package com.dario.kafkaevents.service.impl;

import com.dario.kafkaevents.producer.usecase.KafkaProducer;
import com.dario.kafkaevents.service.KafkaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaServiceImpl implements KafkaService {

  private final KafkaProducer kafkaProducer;

  @Override
  public void sendMessage(String message) {
    kafkaProducer.sendMessage(message);
  }
}
