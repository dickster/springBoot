package com.brovada.controller;

import com.brovada.document.Message;
import com.brovada.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;


@Controller
public class MessageController {

    @Inject
    private MessageRepository messageRepository;

    @MessageMapping("/chat/{to}")
    @SendTo("/topic/messages/{to}")
    public Message chat(@DestinationVariable String to, Message message) throws Exception {
        // hook to alter the message or return another object type that will be posted to /topic/....
        messageRepository.save(message);
        return message;
    }

}