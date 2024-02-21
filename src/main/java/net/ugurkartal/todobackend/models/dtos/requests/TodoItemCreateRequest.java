package net.ugurkartal.todobackend.models.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ugurkartal.todobackend.models.TodoItemStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemCreateRequest {
    private String description;
}