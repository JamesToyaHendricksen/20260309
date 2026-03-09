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
                new TodoView(1L, "Spring Bootの学習", "未着手"),
                new TodoView(2L, "ToDo一覧画面の作成", "進行中"),
                new TodoView(3L, "テストの実施", "完了"));

        model.addAttribute("todos", todos);
        return "todo/list";
    }

    public record TodoView(Long id, String title, String status) {
    }
}
