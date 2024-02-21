package net.ugurkartal.todobackend.models.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptChoice {

    /**
     * {
     *     "message": {
     *         "content": "This is a test!"
     *     }
     * }
     */

    private ChatGptMessage message;
}
