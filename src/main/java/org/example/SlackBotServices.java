package org.example;

import com.slack.api.bolt.App;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SlackBotServices {

    private final App slackApp;

    @Autowired
    public SlackBotServices(App slackApp) {
        this.slackApp = slackApp;
    }

    public void sendMessages(List<String> targetUserIds, String messageText) {
        for (String targetUserId : targetUserIds) {
            sendMessage(targetUserId, messageText);
        }
    }

    public void sendMessage(String targetUserId, String messageText) {
        try {
            Message message = slackApp.client().chatPostMessage(req -> req
                    .channel(targetUserId)  // Use targetUserId as the channel
                    .text(messageText)
            ).getMessage();

            System.out.println("Message sent to " + targetUserId + ": " + message);
        } catch (IOException | SlackApiException e) {
            System.out.println("Error sending message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}