package org.example;


import com.slack.api.bolt.App;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SlackBotServices {

    private final App slackApp;

    @Autowired
    public SlackBotServices(App slackApp) {
        this.slackApp = slackApp;
    }

    public void sendMessage(String channelOrUserId, String messageText) {
        try {
            Message message = slackApp.client().chatPostMessage(req -> req
                    .channel(channelOrUserId)
                    .text(messageText)
            ).getMessage();

            System.out.println("Message sent: " + message);
        } catch(IOException | SlackApiException e) {
            System.out.println("Error sending message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}