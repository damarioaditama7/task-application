package com.example.task.application.repository;

import com.example.task.application.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Query(value = "SELECT * FROM TASK WHERE id = :taskId", nativeQuery = true)
    Task getTaskById(String taskId);

    @Query(value = "SELECT * FROM TASK", nativeQuery = true)
    List<Task> getTaskList();
}
