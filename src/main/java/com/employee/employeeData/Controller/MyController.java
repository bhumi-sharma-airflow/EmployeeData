package com.employee.employeeData.Controller;

import com.employee.employeeData.Entities.Employee;
import com.employee.employeeData.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employeeData")
    public List<Employee> getData()
    {
        return this.employeeService.getData();
    }

    @GetMapping("/employeeData/{employeeId}")
    public Optional<Employee> getData(@PathVariable String employeeId)
    {
        return this.employeeService.getData(Long.parseLong(employeeId));
    }

    @PostMapping("/employeeData")
    public Employee setData(@RequestBody Employee e)
    {
        return this.employeeService.setData(e.getEmployeeName(),e.getDesignation());
    }

    @DeleteMapping("/employeeData/{employeeId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String employeeId){
        try {
            this.employeeService.deleteEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}