package com.hk.robot.config;

import com.plexpt.chatgpt.ChatGPT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : HK意境
 * @ClassName : RobotConfig
 * @date : 2023/5/23 23:09
 * @description :
 * @Todo :
 * @Bug :
 * @Modified :
 * @Version : 1.0
 */
@Configuration
public class RobotConfig {

    @Value("${chat.gpt.key}")
    private String apiKey;
    @Value("${chat.gpt.host}")
    private String host;

    @Bean
    public ChatGPT chatGPT() {

        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey(apiKey)
                .apiHost(host)
                .build()
                .init();

        return chatGPT;
    }



}
