package com.employee.employeeData.Service;

import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Entities.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService
{
    public List<EmployeeDetails> getData(int page, int pageSize);

    ResponseEntity<EmployeeDetails> getData(long employeeId);

    public Employee setData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails);

     ResponseEntity<String> deleteEmployee(long parseLong);

    ResponseEntity<String> updateData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails);
}
