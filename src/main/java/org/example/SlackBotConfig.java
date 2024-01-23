package org.example;

import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackBotConfig {

    @Bean
    public App initSlackApp() {
        AppConfig config = new AppConfig();
        config.setSingleTeamBotToken("xoxb-5791691856791-6492336619815-CD4xZDxF08djT9emJAMbvE4A");

        return new App(config);
    }
}
