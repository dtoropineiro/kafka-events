package com.dario.kafkaevents.producer.usecase;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaProducerGeneralUseCase implements KafkaProducer{

  private final String TOPIC = "input-topic";
  private final String MESSAGE_SENT = "Message sent to topic: {}";
  private final String FAILED_TO_SEND_MESSAGE = "Failed to send message";

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void sendMessage(String message) {

    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(TOPIC, message);

    future.addCallback(new ListenableFutureCallback<>() {

      @Override
      public void onSuccess(SendResult<String, String> result) {
        log.info(MESSAGE_SENT, message);
      }
      @Override
      public void onFailure(Throwable ex) {
        log.error(FAILED_TO_SEND_MESSAGE, ex);
      }
    });
  }
}
