package net.ugurkartal.todobackend.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class TodoItem {
    private String id;
    private String description;
    private TodoItemStatus status;
}