package org.example.service;

import org.example.enums.Status;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task addTask(TaskDto task);

    Task deleteEmployee(Long id);

    Task updatebyId(Task task);

    List<Task> findAllByStatus(Status status);



}
