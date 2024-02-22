package net.ugurkartal.todobackend.controllers;

import lombok.RequiredArgsConstructor;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemCreateRequest;
import net.ugurkartal.todobackend.models.dtos.requests.TodoItemUpdateRequest;
import net.ugurkartal.todobackend.models.dtos.responses.TodoItemGetResponse;
import net.ugurkartal.todobackend.repositories.abstracts.TodoItemRepository;
import net.ugurkartal.todobackend.services.abstracts.TodoItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoItemController {
    private final TodoItemService todoItemService;

    @GetMapping
    public List<TodoItemGetResponse> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public TodoItemGetResponse getTodoItemById(@PathVariable String id) {
        return todoItemService.getTodoItemById(id);
    }

    @PostMapping
    public TodoItemGetResponse addTodoItem(@RequestBody TodoItemCreateRequest todoItemCreateRequest) {
        return todoItemService.addTodoItem(todoItemCreateRequest);
    }

    @PutMapping("/{id}")
    public TodoItemGetResponse updateTodoItem(@PathVariable String id, @RequestBody TodoItemUpdateRequest todoItemUpdateRequest) {
        return todoItemService.updateTodoItem(id, todoItemUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable String id) {
        todoItemService.deleteTodoItem(id);
    }

    @PostMapping("/initialize/{topic}")
    public String generateNewTodoItems(@PathVariable String topic) {
        return todoItemService.generateNewTodoItems(topic);
    }
}