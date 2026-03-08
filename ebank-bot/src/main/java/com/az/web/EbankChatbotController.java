package com.az.web;

import com.az.agents.EbankAIAgent;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")

public class EbankChatbotController {
    @Getter
    private final EbankAIAgent ebankAIAgent;

    public EbankChatbotController(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @GetMapping
    public String chat(@RequestParam(name = "query", defaultValue = "bonjour") String query) {

        return ebankAIAgent.chat(query);
    }
}

