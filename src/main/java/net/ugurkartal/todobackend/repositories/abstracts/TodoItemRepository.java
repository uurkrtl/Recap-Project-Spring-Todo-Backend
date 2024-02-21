package net.ugurkartal.todobackend.repositories.abstracts;

import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.TodoItemStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoItemRepository {
    List<TodoItem> findAll();
    List<TodoItem> findByStatus(TodoItemStatus status);
    TodoItem findById(String id);
    TodoItem save(TodoItem todoItem);
    TodoItem update(TodoItem todoItem);
    void deleteById(String  id);
}