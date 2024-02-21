package net.ugurkartal.todobackend.controllers;

import net.ugurkartal.todobackend.models.TodoItem;
import net.ugurkartal.todobackend.models.TodoItemStatus;
import net.ugurkartal.todobackend.repositories.abstracts.TodoItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TodoItemControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TodoItemRepository todoItemRepository;

    @DirtiesContext
    @Test
    void getAllTodoItems_shouldReturnListWithOneObject_whenOneObjectWasSavedInRepository() throws Exception {
        TodoItem todoItem = new TodoItem("1", "Complete the project", TodoItemStatus.DONE);
        todoItemRepository.save(todoItem);

        mvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                """
                        [
                         {
                             "id": "1",
                             "description": "Complete the project",
                             "status": "DONE"
                         }
                        ]
                        """
                ));
    }

    @Test
    void getTodoItemById_shouldReturnTodoItem_WhenCalledWithValidId() throws Exception {
        TodoItem todoItem = new TodoItem("1", "Complete the project", TodoItemStatus.DONE);
        todoItemRepository.save(todoItem);

        mvc.perform(MockMvcRequestBuilders.get("/api/todo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                    """
                             {
                                 "id": "1",
                                 "description": "Complete the project",
                                 "status": "DONE"
                             }
                            """
                ));
    }

    @Test
    void addTodoItem_shouldReturnNewCharacter_WhenCalledWithValidJSON() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "description": "Write a integration test"
                                }
                                """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                {
                                    "status": "OPEN"
                                }
                                """
                ))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.description").exists());
    }

    @Test
    void updateTodoItem_shouldReturnUpdatedTodoItem_whenGivenUpdatedItem() throws Exception {
        TodoItem todoItem = new TodoItem("1", "Complete the project", TodoItemStatus.DONE);
        todoItemRepository.save(todoItem);

        mvc.perform(MockMvcRequestBuilders.put("/api/todo/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "description": "Write a integration test",
                                    "status": "IN_PROGRESS"
                                }
                                """
                        ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                {
                                    "id": "1",
                                    "description": "Write a integration test",
                                    "status": "IN_PROGRESS"
                                }
                                """
                ));
    }

    @Test
    void deleteTodoItem_deleteCharacter_shouldDeleteChar_whenGivenValidId() throws Exception {
        TodoItem todoItem = new TodoItem("1", "Complete the project", TodoItemStatus.DONE);
        todoItemRepository.save(todoItem);

        mvc.perform(MockMvcRequestBuilders.delete("/api/todo/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }
}