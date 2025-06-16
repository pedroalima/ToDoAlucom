package com.alucom.demo.controllers;

import com.alucom.demo.entities.Tasks;
import com.alucom.demo.services.TasksService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService _tasksService;

    public TasksController(TasksService tasksService) {
        this._tasksService = tasksService;
    }

    @GetMapping
    public List<Tasks> list() {
        return _tasksService.list();
    }

    @PostMapping
    public List<Tasks> create(@RequestBody Tasks task) {
        return _tasksService.create(task);
    }

    @PutMapping("/:{id}")
    public List<Tasks> update(@PathVariable("id") Long id, @RequestBody Tasks task) {
        return _tasksService.update(id, task);
    }

    @DeleteMapping("/:{id}")
    public List<Tasks> delete(@PathVariable("id") Long id) {
        return _tasksService.delete(id);
    }
}
