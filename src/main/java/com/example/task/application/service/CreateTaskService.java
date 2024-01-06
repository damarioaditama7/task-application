package com.example.task.application.service;

import com.example.task.application.entity.Task;
import com.example.task.application.repository.TaskRepository;
import com.example.task.application.request.CreateTaskRequest;
import com.example.task.application.response.CreateTaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

import static com.example.task.application.util.Constant.SYSTEM;
import static com.example.task.application.util.Constant.TASK_STATUS_CREATED;

@Service
public class CreateTaskService {
    private final TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public CreateTaskResponse createTask(CreateTaskRequest input){
        if(ObjectUtils.isEmpty(input.getDescription())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Task is empty, please enter the task"
            );
        }

        Task task = insertTaskIntoDatabase(input);
        return CreateTaskResponse.builder()
                .task(task)
                .build();
    }

    private Task insertTaskIntoDatabase(CreateTaskRequest input) {
        Task task = Task.builder()
                .description(input.getDescription())
                .status(TASK_STATUS_CREATED)
                .deadline(input.getDeadline())
                .createdBy(SYSTEM)
                .createdBy(SYSTEM)
                .updatedBy(SYSTEM)
                .createdAt(new Date(System.currentTimeMillis()))
                .updatedAt(new Date(System.currentTimeMillis()))
                .build();

        task = taskRepository.save(task);
        return task;
    }
}
