package com.employee.employeeData.Service;

import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Dao.EmployeeDao;
import com.employee.employeeData.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<EmployeeDetails> getData(int page)
    {
        List<EmployeeDetails> employeeDetailsList=new LinkedList<>();
        Pageable page1= PageRequest.of(page,3);
        for(Employee employee:employeeDao.findAll(page1))
        {
            EmployeeDetails employeeDetails=new EmployeeDetails(employee.getEmployeeId(), employee.getEmployeeName(), employee.getJoiningDate(), employee.getDesignation());
            employeeDetails.setEmployeeId(employee.getEmployeeId());
            employeeDetails.setEmployeeName(employee.getEmployeeName());
            employeeDetails.setDesignation(employee.getDesignation());
            employeeDetails.setJoiningDate(employee.getJoiningDate());
            employeeDetailsList.add(employeeDetails);
        }
        return employeeDetailsList;
    }

    @Override
    public ResponseEntity<EmployeeDetails> getData(long employeeId)
    {
        Employee employee = employeeDao.getById(employeeId);
        EmployeeDetails employeeDetails = new EmployeeDetails(employee.getEmployeeId(), employee.getEmployeeName(), employee.getJoiningDate(), employee.getDesignation());
        if(employeeDao.existsById(employeeId))
        {
            employeeDetails.setEmployeeId(employee.getEmployeeId());
            employeeDetails.setEmployeeName(employee.getEmployeeName());
            employeeDetails.setDesignation(employee.getDesignation());
            employeeDetails.setJoiningDate(employee.getJoiningDate());
            return ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public EmployeeDetails setData(com.employee.employeeData.DTO.request.EmployeeDetails employeeDetailsObj)
    {
        LocalDateTime createdDate= LocalDateTime.now();
        LocalDateTime updatedDate= LocalDateTime.now();
        LocalDate joiningDate=LocalDate.now();
        Employee employee=new Employee(employeeDetailsObj.getEmployeeName(),joiningDate,createdDate,updatedDate,employeeDetailsObj.getDesignation());
        Employee employee1 = employeeDao.save(employee);
        EmployeeDetails employeeDetails=new EmployeeDetails(employee.getEmployeeId(), employee.getEmployeeName(), employee.getJoiningDate(), employee.getDesignation());
        employeeDetails.setEmployeeId(employee1.getEmployeeId());
        employeeDetails.setEmployeeName(employee1.getEmployeeName());
        employeeDetails.setDesignation(employee1.getDesignation());
        employeeDetails.setJoiningDate(employee1.getJoiningDate());
        return employeeDetails;
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
        if(employeeDao.existsById(employeeDetails.getEmployeeId()))
        {
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