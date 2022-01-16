package com.employee.employeeData.Service;

import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Entities.Employee;

import java.util.List;

public interface EmployeeService
{
    public List<EmployeeDetails> getData();

    public EmployeeDetails getData(long employeeId);

    public Employee setData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails);

    public void deleteEmployee(long parseLong);

    public EmployeeDetails updateData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails);
}
