package com.az.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class EbankChatbotController {

    private final ChatClient chatClient;

    public EbankChatbotController(ChatClient.Builder chatClient, ChatMemory chatMemory) {
        this.chatClient = chatClient.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()) // Utilise la mémoire pour garder le contexte de la conversation
                .build();
    }

    @GetMapping
    public String chat(@RequestParam(name = "query", defaultValue = "bonjour") String query) {
        try {
            String response = chatClient.prompt(query).call().content();
            return response;
        } catch (Exception e) {
            // Affiche le vrai message d'erreur (clé invalide, pas de crédits, etc.)
            String errorMsg = "Erreur OpenAI: " + e.getMessage();
            if (e.getCause() != null) {
                errorMsg += " | Cause: " + e.getCause().getMessage();
            }
            return errorMsg;
        }
    }
}
