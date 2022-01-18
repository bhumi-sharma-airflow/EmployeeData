package com.employee.employeeData.Controller;
import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MyController
{
    //It autowired the EmployeeService with MyController
    @Autowired
    private EmployeeService employeeService;

    //Used for get all the data from the Database with pagination
    @GetMapping("/employeeData")
    public List<EmployeeDetails> getData(@RequestParam("page") int page)
    {
        return this.employeeService.getData(page);
    }

    //Used for get data of particualar employee whose employee id is passed
    @GetMapping("/employeeData/{employeeId}")
    public ResponseEntity<EmployeeDetails> getData(@PathVariable String employeeId)
    {
        return this.employeeService.getData(Long.parseLong(employeeId));
    }

    //It stores the data into Database
    @PostMapping("/employeeData")
    public EmployeeDetails setData(@RequestBody com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails)
    {
        return this.employeeService.setData(employeeDetails);
    }

    //It updates the data of the particular Employee according to the Employee Id
    @PutMapping("/employeeData")
    public ResponseEntity<String> updateData(@RequestBody com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails)
    {
        return this.employeeService.updateData(employeeDetails);
    }

    //It Delete the Particular Employee from Database
    @DeleteMapping("/employeeData/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId)
    {
      return this.employeeService.deleteEmployee(Long.parseLong(employeeId));
    }
}