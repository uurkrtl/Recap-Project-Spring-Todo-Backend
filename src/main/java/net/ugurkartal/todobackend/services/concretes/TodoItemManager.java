package net.ugurkartal.todobackend.services.concretes;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemCreateRequest;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemUpdateRequest;
import net.ugurkartal.todobackend.models.dtos.responses.TodoItemGetResponse;
import net.ugurkartal.todobackend.repositories.abstracts.TodoItemRepository;
import net.ugurkartal.todobackend.services.abstracts.TodoItemService;
import net.ugurkartal.todobackend.services.mappers.TodoItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoItemManager implements TodoItemService {
    private final TodoItemRepository todoItemRepository;
    private final TodoItemMapper todoItemMapper;
    private final ChatGptManager chatGptManager;
    @Override
    public List<TodoItemGetResponse> getAllTodoItems() {
        return this.todoItemMapper.itemsToItemsGetResponse(todoItemRepository.findAll());
    }

    @Override
    public TodoItemGetResponse getTodoItemById(String id) {
        return this.todoItemMapper.itemToItemGetResponse(todoItemRepository.findById(id).orElse(null));
    }

    @Override
    public TodoItemGetResponse addTodoItem(TodoItemCreateRequest todoItemCreateRequest) {
        TodoItem newTodoItem = this.todoItemMapper.createToItem(todoItemCreateRequest).withStatus(TodoItemStatus.OPEN).withId(String.valueOf(UUID.randomUUID()));
        String chatGptMessage = chatGptManager.askQuestion(newTodoItem.getDescription());
        newTodoItem.setDescription(chatGptMessage.charAt(chatGptMessage.length()-1) == '.' ? chatGptMessage.substring(0, chatGptMessage.length()-1) : chatGptMessage);
        newTodoItem = this.todoItemRepository.save(newTodoItem);
        return this.todoItemMapper.itemToItemGetResponse(newTodoItem);
    }

    @Override
    public TodoItemGetResponse updateTodoItem(String id, TodoItemUpdateRequest todoItemUpdateRequest) {
        TodoItem todoItem = this.todoItemRepository.save(this.todoItemMapper.updateToItem(todoItemUpdateRequest).withId(id));
        todoItem.setId(id);
        return this.todoItemMapper.itemToItemGetResponse(todoItem);
    }

    @Override
    public void deleteTodoItem(String id) {
        this.todoItemRepository.deleteById(id);
    }
}