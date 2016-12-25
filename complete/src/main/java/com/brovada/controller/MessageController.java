package com.brovada.controller;

import com.brovada.document.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class MessageController {

    @MessageMapping("/chat/{to}")
    @SendTo("/topic/messages/{to}")
    public Message chat(@DestinationVariable String to, Message message) throws Exception {
        // hook to alter the message or return another object type that will be posted to /topic/....
        return message;
    }

}