package com.az.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class EbankAIAgent {
    private final ChatClient chatClient;

    public EbankAIAgent(ChatClient.Builder chatClient, ChatMemory chatMemory) {
        this.chatClient = chatClient.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()) // Utilise la mémoire pour garder le contexte de la conversation
                .build();
    }


    public String chat(String query) {
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
