package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String list(Model model) {
        List<TodoView> todos = List.of(
                new TodoView(1L, "Learn Spring Boot", "Not Started"),
                new TodoView(2L, "Build ToDo list page", "In Progress"),
                new TodoView(3L, "Run tests", "Done"));

        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @GetMapping("/new")
    public String createForm() {
        return "todo/new";
    }

    public record TodoView(Long id, String title, String status) {
    }
}