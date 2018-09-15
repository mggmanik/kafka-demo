package com.stackroute.tldm.consumer;

import com.stackroute.tldm.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private SimpMessagingTemplate template;

    @Autowired
    public Receiver(SimpMessagingTemplate template) {
        this.template = template;
    }

//    @KafkaListener(topics = "${topic.boot}")
//    public void receive(ConsumerRecord<String, Message> consumerRecord) throws Exception {
//        Message message = consumerRecord.value();
//        template.convertAndSend("/topic/response", new Message(message.getMessageId(), message.getMessageContent(), message.getSender(), message.getReceiver(), message.getCreatedAt()));
//    }

    @KafkaListener(topics = "${topic.boot}")
    public void receive(@Payload Message message) {
        System.out.println();
        template.convertAndSend("/topic/response", message);
    }
}
