package net.ugurkartal.todobackend.services.mappers;

import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemCreateRequest;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemUpdateRequest;
import net.ugurkartal.todobackend.models.dtos.responses.TodoItemGetResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoItemMapper {
    public TodoItem createToItem(TodoItemCreateRequest todoItemCreateRequest) {
        return TodoItem.builder().description(todoItemCreateRequest.getDescription()).build();
    }

    public TodoItem updateToItem(TodoItemUpdateRequest todoItemUpdateRequest) {
        return TodoItem.builder().description(todoItemUpdateRequest.getDescription()).status(todoItemUpdateRequest.getStatus()).build();
    }

    public TodoItemGetResponse itemToItemGetResponse(TodoItem todoItem) {
        return TodoItemGetResponse.builder().id(todoItem.getId()).description(todoItem.getDescription()).status(todoItem.getStatus()).build();
    }

    public List<TodoItemGetResponse> itemsToItemsGetResponse(List<TodoItem> todoItemList) {
        return todoItemList.stream()
                .map(this::itemToItemGetResponse)
                .toList();
    }
}