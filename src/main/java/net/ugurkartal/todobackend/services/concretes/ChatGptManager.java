package net.ugurkartal.todobackend.services.concretes;

import net.ugurkartal.todobackend.models.chatgpt.ChatGPTRequest;
import net.ugurkartal.todobackend.models.chatgpt.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ChatGptManager {
    private final RestClient client;

    public ChatGptManager(
            @Value("${open.ai.key}") String apikey,
            @Value("${open.ai.url}") String baseurl){
        client = RestClient.builder()
                .baseUrl(baseurl)
                .defaultHeader("Authorization", "Bearer " + apikey)
                .build();
    }

    public String askQuestion(String description) {
        String question = "Spelling and grammar correction for todo list (Just write the text you corrected): " + description;
        ChatGPTRequest request = new ChatGPTRequest(question);
        ChatGPTResponse response = client.post()
                .body(request)
                .retrieve()
                .body(ChatGPTResponse.class);
        return response.getAnswer();
    }
}