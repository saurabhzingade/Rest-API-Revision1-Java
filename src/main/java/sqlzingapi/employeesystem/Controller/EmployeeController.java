package sqlzingapi.employeesystem.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sqlzingapi.employeesystem.DTO.EmployeeDTO;
import sqlzingapi.employeesystem.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Employee Add api
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
       EmployeeDTO savedEmployee= employeeService.createEmployee(employeeDTO);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get an employee  by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeebyID(@PathVariable Long id)
    {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
    }

    //Get all Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Update the employee in this one
    @PutMapping("{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeDTO updatedEmployee)
    {
        EmployeeDTO employeeDTO= employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }

    // Delete the employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee is deleted");
    }

}
