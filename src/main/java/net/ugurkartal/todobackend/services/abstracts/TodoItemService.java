package net.ugurkartal.todobackend.services.abstracts;

import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemCreateRequest;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemUpdateRequest;
import net.ugurkartal.todobackend.models.dtos.responses.TodoItemGetResponse;

import java.util.List;

public interface TodoItemService {
    List<TodoItemGetResponse> getAllTodoItems();
    TodoItemGetResponse getTodoItemById(String id);
    TodoItemGetResponse addTodoItem(TodoItemCreateRequest todoItemCreateRequest);
    TodoItemGetResponse updateTodoItem(String id, TodoItemUpdateRequest todoItemUpdateRequest);
    void deleteTodoItem(String id);
}