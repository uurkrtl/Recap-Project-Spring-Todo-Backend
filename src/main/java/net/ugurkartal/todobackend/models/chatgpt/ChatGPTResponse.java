package net.ugurkartal.todobackend.models.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTResponse {

    /**
     * {
     *     "choices": [
     *         {
     *             "message": {
     *                 "content": "This is a test!"
     *             }
     *         }
     *     ]
     * }
     */

    private List<ChatGptChoice> choices;

    public String getAnswer(){
        return getChoices().get(0).getMessage().getContent();
    }
}
