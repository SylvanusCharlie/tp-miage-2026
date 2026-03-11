package com.acme.todolist.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoItemTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Rajoute un late a la todo item")
    void addLateToFinalContentTest() {
        TodoItem todo = new TodoItem("0f8-06eb17ba8d34", Instant.parse("2020-02-27T10:31:43Z"), "Faire les courses");

        assertTrue(todo.finalContent().startsWith("[LATE!] "));
    }

    @Test
    @DisplayName("Ne rajoute pas un late a la todo item")
    void oFinalContentTest() {
        TodoItem todo = new TodoItem("0f8-06eb17ba8d34", Instant.parse("2026-03-11T10:31:43Z"), "Faire les courses");

        assertFalse(todo.finalContent().startsWith("[LATE!] "));
    }
}
