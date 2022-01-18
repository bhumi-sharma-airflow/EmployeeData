package com.employee.employeeData.Service;
import com.employee.employeeData.DTO.response.EmployeeDetails;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface EmployeeService
{
    List<EmployeeDetails> getData(int page);
    ResponseEntity<EmployeeDetails> getData(long employeeId);
    EmployeeDetails setData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails);
    ResponseEntity<String> deleteEmployee(long employeeId);
    ResponseEntity<String> updateData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails);
}