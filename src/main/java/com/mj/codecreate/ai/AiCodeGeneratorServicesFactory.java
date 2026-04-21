package com.mj.codecreate.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工厂模式 - 简化创建过程
 * Ai服务创建
 *
 */
//@Configuration 注解，配置类
@Configuration
public class AiCodeGeneratorServicesFactory {

    @Resource
    public ChatModel chatModel;

    @Resource
    public StreamingChatModel streamingChatModel;

    /**
     * 快速创建AI代码生成器服务
     *
     * @return //实现类
     */
    @Bean
    public AiCodeGeneratorServices aiCodeGeneratorServices() {
        return AiServices.builder(AiCodeGeneratorServices.class)
                .chatModel(chatModel)
                .streamingChatModel(streamingChatModel)
                .build();
    }
}
