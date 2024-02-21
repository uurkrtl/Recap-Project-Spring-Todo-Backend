package net.ugurkartal.todobackend.repositories.concretes;

import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.repositories.abstracts.TodoItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TodoItemListRepository implements TodoItemRepository {
    private List<TodoItem> todoItemList;

    public TodoItemListRepository() {
        todoItemList = new ArrayList<>();
        todoItemList.add(new TodoItem("1L", "First Todo Item", TodoItemStatus.OPEN));
        todoItemList.add(new TodoItem("2L", "Second Todo Item", TodoItemStatus.IN_PROGRESS));
        todoItemList.add(new TodoItem("3L", "Third Todo Item", TodoItemStatus.OPEN));
        todoItemList.add(new TodoItem("4L", "Fourth Todo Item", TodoItemStatus.DONE));
        todoItemList.add(new TodoItem("5L", "Fifth Todo Item", TodoItemStatus.IN_PROGRESS));
    }

    @Override
    public List<TodoItem> findAll() {
        return todoItemList;
    }

    @Override
    public List<TodoItem> findByStatus(TodoItemStatus status) {
        return todoItemList.stream()
                .filter(todoItem -> todoItem.getStatus() == status)
                .toList();
    }

    @Override
    public TodoItem findById(String  id) {
        return todoItemList.stream()
                .filter(todoItem -> todoItem.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public TodoItem save(TodoItem todoItem) {
        todoItemList.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        for (int i = 0; i < todoItemList.size(); i++) {
            if (todoItemList.get(i).getId().equals(todoItem.getId())) {
                todoItemList.set(i, todoItem);
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        todoItemList.removeIf(todoItem -> todoItem.getId().equals(id));
    }
}