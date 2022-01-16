package com.employee.employeeData.Service;

import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Dao.EmployeeDao;
import com.employee.employeeData.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService
{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeDetails> getData()
    {
        List<EmployeeDetails> employeeDetailsList=new LinkedList<>();
        for(Employee employee:employeeDao.findAll())
        {
            EmployeeDetails employeeDetails=new EmployeeDetails();
            employeeDetails.setEmployeeId(employee.getEmployeeId());
            employeeDetails.setEmployeeName(employee.getEmployeeName());
            employeeDetails.setDesignation(employee.getDesignation());
            employeeDetails.setJoiningDate(employee.getJoiningDate());
            employeeDetailsList.add(employeeDetails);
        }
        return employeeDetailsList;
    }

    @Override
    public EmployeeDetails getData(long employeeId)
    {
        Employee employee=employeeDao.getById(employeeId);
        EmployeeDetails employeeDetails=new EmployeeDetails();
        employeeDetails.setEmployeeId(employee.getEmployeeId());
        employeeDetails.setEmployeeName(employee.getEmployeeName());
        employeeDetails.setDesignation(employee.getDesignation());
        employeeDetails.setJoiningDate(employee.getJoiningDate());
        return employeeDetails;

    }

    @Override
    public Employee setData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails)
    {
        LocalDateTime createdDate= LocalDateTime.now();
        LocalDateTime updatedDate= LocalDateTime.now();
        LocalDate joiningDate=LocalDate.now();
        Employee employee=new Employee(employeeDetails.getEmployeeName(),joiningDate,createdDate,updatedDate,employeeDetails.getDesignation());
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public ResponseEntity<String> deleteEmployee(long parseLong)
    {
        if(employeeDao.existsById(parseLong))
        {
            Employee entity=employeeDao.getById(parseLong);
            employeeDao.delete(entity);
            return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Sucessfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
    }

    @Override
    public ResponseEntity<String> updateData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails)
    {

        if(employeeDao.existsById(employeeDetails.getEmployeeId())) {
            Employee employee = employeeDao.getById(employeeDetails.getEmployeeId());
            employee.setEmployeeName(employeeDetails.getEmployeeName());
            employee.setDesignation(employeeDetails.getDesignation());
            LocalDateTime dateTime = LocalDateTime.now();
            employee.setUpdatedDate(dateTime);
            Employee employee1= employeeDao.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not found");
    }
}
