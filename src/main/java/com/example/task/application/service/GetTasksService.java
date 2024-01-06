package com.example.task.application.service;

import com.example.task.application.entity.Task;
import com.example.task.application.repository.TaskRepository;
import com.example.task.application.response.GetTasksResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GetTasksService {
    private final TaskRepository taskRepository;

    public GetTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public GetTasksResponse getTasks() {
        List<Task> tasks = taskRepository.getTaskList();

        if(ObjectUtils.isEmpty(tasks)){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Task list is empty"
            );
        }

        return GetTasksResponse.builder()
                .tasks(tasks)
                .build();
    }
}
