package com.employee.employeeData.Dao;
import com.employee.employeeData.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//It Creates the Dao Layer with the Help of JPA Repository have Employee and Long as parentheses
public interface EmployeeDao extends JpaRepository<Employee, Long>
{
}