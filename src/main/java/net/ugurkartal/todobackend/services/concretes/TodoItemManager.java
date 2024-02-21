package net.ugurkartal.todobackend.services.concretes;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemCreateRequest;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemUpdateRequest;
import net.ugurkartal.todobackend.models.dtos.responses.TodoItemGetResponse;
import net.ugurkartal.todobackend.repositories.abstracts.TodoItemRepository;
import net.ugurkartal.todobackend.repositories.concretes.TodoItemListRepository;
import net.ugurkartal.todobackend.services.abstracts.TodoItemService;
import net.ugurkartal.todobackend.services.mappers.TodoItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoItemManager implements TodoItemService {
    private final TodoItemRepository todoItemRepository;
    private final TodoItemMapper todoItemMapper;
    @Override
    public List<TodoItemGetResponse> getAllTodoItems() {
        return this.todoItemMapper.itemsToItemsGetResponse(todoItemRepository.findAll());
    }

    @Override
    public List<TodoItemGetResponse> getByStatusItems(TodoItemStatus status) {
        return this.todoItemMapper.itemsToItemsGetResponse(todoItemRepository.findByStatus(status));
    }

    @Override
    public TodoItemGetResponse getTodoItemById(Long id) {
        return this.todoItemMapper.itemToItemGetResponse(todoItemRepository.findById(id));
    }

    @Override
    public TodoItemGetResponse createTodoItem(TodoItemCreateRequest todoItemCreateRequest) {
        TodoItem todoItem = this.todoItemRepository.save(this.todoItemMapper.createToItem(todoItemCreateRequest));
        return this.todoItemMapper.itemToItemGetResponse(todoItem);
    }

    @Override
    public TodoItemGetResponse updateTodoItem(Long id, TodoItemUpdateRequest todoItemUpdateRequest) {
        TodoItem todoItem = this.todoItemRepository.update(this.todoItemMapper.updateToItem(todoItemUpdateRequest));
        return this.todoItemMapper.itemToItemGetResponse(todoItem);
    }

    @Override
    public void deleteTodoItem(Long id) {
        this.todoItemRepository.deleteById(id);
    }
}