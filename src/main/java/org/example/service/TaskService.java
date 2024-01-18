package org.example.service;

import org.example.enums.Status;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task addTask(Task task);

    List<Task> getTask(Long employeeId, Status status);

    List<Task> getTask(Long employeeId);

    List<Task> getTasks();

}