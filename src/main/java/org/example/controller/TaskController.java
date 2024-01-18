package org.example.controller;

import org.example.enums.Status;
import org.example.exception.EmployeeNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTask() {
        return taskService.getAllTasks();
    }


    @PostMapping("")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto) {
        Task savedTask = taskService.addTask(taskDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTaskBy(@PathVariable Long id)
    {
        try {
            Task task = taskService.deleteEmployee(id);
            return ResponseEntity.ok(task);
        }
        catch (TaskNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public Task updateEmployeeBy(@RequestBody Task task){
        return taskService.updatebyId(task);

    }

    @GetMapping("/taskbystatus/{status}")
    public List<Task> taskBYStatus(Status status) {
        return taskService.findAllByStatus(status);
    }

}
