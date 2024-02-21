package net.ugurkartal.todobackend.services.abstracts;

import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemCreateRequest;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemUpdateRequest;
import net.ugurkartal.todobackend.models.dtos.responses.TodoItemGetResponse;

import java.util.List;

public interface TodoItemService {
    List<TodoItemGetResponse> getAllTodoItems();
    List<TodoItemGetResponse> getByStatusItems(TodoItemStatus status);
    TodoItemGetResponse getTodoItemById(Long id);
    TodoItemGetResponse createTodoItem(TodoItemCreateRequest todoItemCreateRequest);
    TodoItemGetResponse updateTodoItem(Long id, TodoItemUpdateRequest todoItemUpdateRequest);
    void deleteTodoItem(Long id);
}