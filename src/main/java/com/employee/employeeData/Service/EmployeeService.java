package com.employee.employeeData.Service;

import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService
{
    public List<EmployeeDetails> getData();

    public Optional<Employee> getData(long employeeId);

    public Employee setData(String Name, String Designation);

    public void deleteEmployee(long parseLong);
}
