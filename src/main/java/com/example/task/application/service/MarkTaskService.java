package com.example.task.application.service;

import com.example.task.application.entity.Task;
import com.example.task.application.repository.TaskRepository;
import com.example.task.application.request.MarkTaskRequest;
import com.example.task.application.response.MarkTaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import static com.example.task.application.util.Constant.TASK_STATUS_COMPLETED;

@Service
public class MarkTaskService {
    private final TaskRepository taskRepository;

    public MarkTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public MarkTaskResponse markTaskComplete(MarkTaskRequest input) {
        if (!StringUtils.hasText(input.getTaskId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "TaskID is empty"
            );
        }
        Task task = taskRepository.getTaskById(input.getTaskId());

        if (ObjectUtils.isEmpty(task)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Task not found in database"
            );
        }

        task.setStatus(TASK_STATUS_COMPLETED);

        task = taskRepository.save(task);

        return MarkTaskResponse.builder()
                .task(task)
                .build();
    }
}
