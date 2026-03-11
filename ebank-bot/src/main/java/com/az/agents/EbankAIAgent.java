package com.az.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class EbankAIAgent {
    private final ChatClient chatClient;

    public EbankAIAgent(ChatClient.Builder chatClient,
                        ChatMemory chatMemory, ToolCallbackProvider tools) {
        this.chatClient = chatClient
                .defaultSystem("""
                        Vous un assistant qui se charge de répondre aux question
                        de l'utilisateur à propos des clients et des comptes bancaires, en fonction du contexte fourni.
                        Si aucun contexte n'est fourni, répond avec JE NE SAIS PAS  
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(tools)
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
