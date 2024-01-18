package org.example.service;

import org.example.enums.Status;
import org.example.exception.EmployeeNotFoundException;
import org.example.exception.TaskNotFoundException;
import org.example.model.entity.Task;
import org.example.model.dto.TaskDto;

import org.example.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TaskServiceImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }


    @Override
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Task addTask(TaskDto task) {
        return tasksRepository.save(new Task(task));
    }

    @Override
    public Task deleteEmployee(Long id) {

       Task taskToDelete = tasksRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id: " + id));

       if(taskToDelete !=null){
           tasksRepository.deleteById(id);

           return taskToDelete;
       }
       else {

           throw new EmployeeNotFoundException("Task not found with id: " + id);
       }
    }

    @Override
    public Task updatebyId(Task task) {
        return tasksRepository.save(task);
    }

    @Override
    public List<Task> findAllByStatus(Status status) {
        return this.tasksRepository.findAllByStatus(status);
    }

}
