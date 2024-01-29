package org.example.model;

import org.example.enums.Status;
import org.example.model.dto.EmployeeDto;
import org.example.model.dto.TaskDto;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskUnitTest {
    @Test
    public void testTaskEntity(){
        Employee employee = new Employee();
        Task task = new Task(1L,"description",Status.NEW,employee);
        Assertions.assertEquals(1L,task.getId());
        Assertions.assertEquals("description",task.getDescription());
        Assertions.assertEquals("NEW",Status.NEW.toString());
        Assertions.assertNotNull(employee);

    }
    @Test
    public void TaskDtoConstructorTest(){
        TaskDto taskDto = new TaskDto();

        taskDto.setDescription("Description");

        Task task = new Task(taskDto);
        Assertions.assertEquals(taskDto.getDescription(), task.getDescription());
    }
    @Test
    public void NoArgsConstructorTest(){
        Task task = new Task();

        Assertions.assertNotNull(task);
    }
}
