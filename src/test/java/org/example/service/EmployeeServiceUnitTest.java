package org.example.service;

import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceUnitTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @org.junit.Test
    public void getAllEmployeeTest(){
        List<Employee> expectedEmployees = Collections.singletonList(new Employee(0L,"guy@gmail.com","Beloved","Nethengwe","Developer"));
        when(employeeService.getAllEmployees()).thenReturn(expectedEmployees);

        List<Employee> resultEmployee = employeeService.getAllEmployees();
        assertEquals(expectedEmployees,resultEmployee);
    }

    @Test
    public void deleteEmployeeTest(){
        Employee employee = new Employee();
        employee.setId(1L);

        employeeRepository.deleteById(employee.getId());
        verify(employeeRepository).deleteById(employee.getId());
    }


}
