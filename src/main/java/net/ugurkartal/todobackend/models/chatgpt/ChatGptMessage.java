package net.ugurkartal.todobackend.models.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptMessage {

    /**
     * {
     *     "role": "user",
     *     "content": "Say this is a test!"
     *  }
     */

    private String role;
    private String content;

    public ChatGptMessage(String question){
        this.role = "user";
        this.content = question;
    }
}