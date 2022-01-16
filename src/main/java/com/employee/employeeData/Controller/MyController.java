package com.employee.employeeData.Controller;
import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Entities.Employee;
import com.employee.employeeData.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MyController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employeeData")
    public List<EmployeeDetails> getData()
    {
        return this.employeeService.getData();
    }

    @GetMapping("/employeeData/{employeeId}")
    public EmployeeDetails getData(@PathVariable String employeeId)
    {
        return this.employeeService.getData(Long.parseLong(employeeId));
    }

    @PostMapping("/employeeData")
    public Employee setData(@RequestBody com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails)
    {
        return this.employeeService.setData(employeeDetails);
    }
    @PutMapping("/employeeData")
    public ResponseEntity<String>  updateData(@RequestBody com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails)
    {
        return this.employeeService.updateData(employeeDetails);
    }

    @DeleteMapping("/employeeData/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId)
    {
      return this.employeeService.deleteEmployee(Long.parseLong(employeeId));
    }
}