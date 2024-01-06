package com.example.task.application.controller;

import com.example.task.application.request.CreateTaskRequest;
import com.example.task.application.request.MarkTaskRequest;
import com.example.task.application.response.CreateTaskResponse;
import com.example.task.application.response.GetTasksResponse;
import com.example.task.application.response.MarkTaskResponse;
import com.example.task.application.service.CreateTaskService;
import com.example.task.application.service.GetTasksService;
import com.example.task.application.service.MarkTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task/v1")
public class TaskController {

    private final CreateTaskService createTaskService;
    private final MarkTaskService markTaskService;
    private final GetTasksService getTasksService;

    public TaskController(CreateTaskService createTaskService, MarkTaskService markTaskService, GetTasksService getTasksService) {
        this.createTaskService = createTaskService;
        this.markTaskService = markTaskService;
        this.getTasksService = getTasksService;
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.OK)
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest request) {
        return createTaskService.createTask(request);
    }

    @PostMapping("/complete")
    @ResponseStatus(value = HttpStatus.OK)
    public MarkTaskResponse completeTask(@RequestBody MarkTaskRequest request) {
        return markTaskService.markTaskComplete(request);
    }

    @GetMapping("/list")
    @ResponseStatus(value = HttpStatus.OK)
    public GetTasksResponse completeTask() {
        return getTasksService.getTasks();
    }
}
