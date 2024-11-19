package sqlzingapi.employeesystem.Mapper;

import sqlzingapi.employeesystem.DTO.EmployeeDTO;
import sqlzingapi.employeesystem.Entity.Employee;

public class EmploeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO)
    {
        return new Employee(
          employeeDTO.getId(),
          employeeDTO.getFirstName(),
          employeeDTO.getLastName(),
          employeeDTO.getEmail()
        );
    }
}
