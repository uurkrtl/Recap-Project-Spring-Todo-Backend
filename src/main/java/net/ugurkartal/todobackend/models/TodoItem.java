package net.ugurkartal.todobackend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoItem {
    private long id;
    private String description;
    private TodoItemStatus status;
}