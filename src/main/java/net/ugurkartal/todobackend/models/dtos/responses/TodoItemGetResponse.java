package net.ugurkartal.todobackend.models.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ugurkartal.todobackend.models.TodoItemStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoItemGetResponse {
    private String id;
    private String description;
    private TodoItemStatus status;
}