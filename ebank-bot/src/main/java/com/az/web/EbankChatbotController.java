package com.az.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot")

public class EbankChatbotController {
    private final ChatClient chatClient;

    public EbankChatbotController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping
    public String chat(@RequestParam String query) {
        return chatClient.prompt(query).call().content();

    }
}
