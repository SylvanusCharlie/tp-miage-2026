package com.acme.todolist.adapters.persistence;

import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoItemRepositoryTest {

    @Autowired
    private  TodoItemRepository todoItemRepository ;

    @BeforeEach
    void setUp() {
        todoItemRepository.deleteAll();
    }

    @Test
    @DisplayName("Sauvegarde en base de données")
    void shouldSaveAnItem() {
        TodoItemJpaEntity item = new TodoItemJpaEntity("0f8-06eb17ba8d34", Instant.parse("2020-02-27T10:31:43Z"), "Faire les courses", true);

        todoItemRepository.save(item);

        Optional<TodoItemJpaEntity> saved = todoItemRepository.findById(item.getId());

        assert(saved.isPresent());

    }
}
