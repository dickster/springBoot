package com.brovada.controller;

import com.brovada.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message chat(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay - debug only.
        return message;
    }

//    @MessageMapping("/fleet/{fleetId}/driver/{driverId}")
//    @SendTo("/topic/fleet/{fleetId}")
//    public Simple simple(@DestinationVariable String fleetId, @DestinationVariable String driverId) {
//        return new Simple(fleetId, driverId);
//    }

}