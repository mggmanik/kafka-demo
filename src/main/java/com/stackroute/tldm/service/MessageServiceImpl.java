package com.stackroute.tldm.service;

import com.stackroute.tldm.model.Message;
import com.stackroute.tldm.model.User;
import com.stackroute.tldm.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(Message message) {
//        User sender = new User("1", "Manik", "mggmanik@gmail.com", "7060186830");
//        User receiver = new User("2", "Diwakar", "adiwakar@gmail.com", "9882735413");
//        message.setSender(sender);
//        message.setReceiver(receiver);
        message.setCreatedAt(new Date());
        messageRepository.insert(message);
    }
}
