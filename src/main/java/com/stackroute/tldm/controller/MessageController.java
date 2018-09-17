package com.stackroute.tldm.controller;

import com.stackroute.tldm.model.Message;
import com.stackroute.tldm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private MessageService messageService;
    private KafkaTemplate<String, Message> kafkaTemplate;
    private static String BOOT_TOPIC = "message";

    @Autowired
    public MessageController(MessageService messageService, KafkaTemplate<String, Message> kafkaTemplate) {
        this.messageService = messageService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @MessageMapping("/chat")
    public void sendMessage(Message message) throws Exception {
        messageService.createMessage(message);
        kafkaTemplate.send(BOOT_TOPIC, message);
    }
}