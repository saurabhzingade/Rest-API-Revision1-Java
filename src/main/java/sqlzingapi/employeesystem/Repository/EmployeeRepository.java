package sqlzingapi.employeesystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sqlzingapi.employeesystem.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
