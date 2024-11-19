package sqlzingapi.employeesystem.Service;

import sqlzingapi.employeesystem.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedemployee);

    void deleteEmployee(Long employeeId);
}
