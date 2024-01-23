package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SlackController {

    private final SlackBotServices slackBotService;
    private static final String DEFAULT_CHANNEL_ID = "C05QDTGAP8Q";

    @Autowired
    public SlackController(SlackBotServices slackBotService) {
        this.slackBotService = slackBotService;
    }

    @PostMapping("/slack/send-message")
    public String sendMessage( MessageRequest messageRequest) {
        String channel = (messageRequest.getChannel() != null) ? messageRequest.getChannel() : DEFAULT_CHANNEL_ID;
        String messageText = "this is bot with url:<https://github.com/parthGalani/Spring-App>";

        slackBotService.sendMessage(channel, messageText);

        return "Messages sent!";
    }
    public static class MessageRequest {
        private String channel;
        private String text;

        // Getters and setters

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}