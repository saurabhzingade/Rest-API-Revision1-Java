package sqlzingapi.employeesystem.Service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sqlzingapi.employeesystem.DTO.EmployeeDTO;
import sqlzingapi.employeesystem.Entity.Employee;
import sqlzingapi.employeesystem.Exception.ResourceNotFoundException;
import sqlzingapi.employeesystem.Mapper.EmploeeMapper;
import sqlzingapi.employeesystem.Repository.EmployeeRepository;
import sqlzingapi.employeesystem.Service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmploeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmploeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist" + employeeId));
        return EmploeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map((employee)->EmploeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedemployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee with that id does not exist"));
        employee.setFirstName(updatedemployee.getFirstName());
        employee.setLastName(updatedemployee.getLastName());
        employee.setEmail(updatedemployee.getEmail());

        Employee updatedEmpoyee= employeeRepository.save(employee);

        return EmploeeMapper.mapToEmployeeDTO(updatedEmpoyee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee with that id does not exist"));
        employeeRepository.deleteById(employeeId);
    }


}
