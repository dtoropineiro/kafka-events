package com.dario.kafkaevents.controller;

import com.dario.kafkaevents.service.KafkaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class KafkaController {

  private final KafkaService kafkaService;

  @PostMapping("/message")
  public void addMessage(@RequestBody String message) {
    kafkaService.sendMessage(message);
  }
}
