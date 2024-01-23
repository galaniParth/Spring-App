package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SlackController {

    private final SlackBotServices slackBotService;


    @Autowired
    public SlackController(SlackBotServices slackBotService) {
        this.slackBotService = slackBotService;
    }

    @PostMapping("/slack/send-message")
    public String sendMessage(@RequestBody MessageRequest messageRequest) {
        List<String> targets = messageRequest.getTargets();
        String messageText = "this is bot";

        slackBotService.sendMessage(String.valueOf(targets), messageText);

        return "Messages sent!";
    }

}