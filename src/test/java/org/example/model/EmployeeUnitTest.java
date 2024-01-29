package org.example.model;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeUnitTest {
  @Test
    public void testEmployeeEntity(){
      Employee employee = new Employee(1L,"jon@mail.com","John","Doe","Designer");

      Assertions.assertEquals(1L, employee.getId());
      Assertions.assertEquals("jon@mail.com", employee.getEmail());
      Assertions.assertEquals("John", employee.getFirstName());
      Assertions.assertEquals("Doe", employee.getLastName());
      Assertions.assertEquals("Designer", employee.getPosition());

    }

  @Test
    public void EmployeeDtoConstructorTest(){
      EmployeeDto employeeDto = new EmployeeDto();
      employeeDto.setFirstName("John");

      Employee employee = new Employee(employeeDto);

      Assertions.assertEquals(employeeDto.getFirstName(), employee.getFirstName());
    }

  @Test
  public void NoArgsConstructorTest(){
    Employee employee = new Employee();

    Assertions.assertNotNull(employee);
  }

}
