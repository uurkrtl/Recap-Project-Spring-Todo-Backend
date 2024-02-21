package net.ugurkartal.todobackend.repositories.concretes;

import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.repositories.abstracts.TodoItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoItemListRepository implements TodoItemRepository {
    private List<TodoItem> todoItemList;

    public TodoItemListRepository(List<TodoItem> todoItemList) {
        this.todoItemList = List.of(
                new TodoItem(1L, "First Todo Item", TodoItemStatus.TODO),
                new TodoItem(2L, "Second Todo Item", TodoItemStatus.DOING),
                new TodoItem(3L, "Third Todo Item", TodoItemStatus.TODO),
                new TodoItem(4L, "Fourth Todo Item", TodoItemStatus.DONE),
                new TodoItem(5L, "Fifth Todo Item", TodoItemStatus.DOING));
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
    public TodoItem findById(Long id) {
        return todoItemList.stream()
                .filter(todoItem -> todoItem.getId() == id)
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
            if (todoItemList.get(i).getId() == todoItem.getId()) {
                todoItemList.set(i, todoItem);
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        todoItemList.removeIf(todoItem -> todoItem.getId() == id);
    }
}