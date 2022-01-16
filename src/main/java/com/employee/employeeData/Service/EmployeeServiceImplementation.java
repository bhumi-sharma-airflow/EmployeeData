package com.employee.employeeData.Service;

import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Dao.EmployeeDao;
import com.employee.employeeData.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> getData(long employeeId)
    {
        return employeeDao.findById(employeeId);
    }

    @Override
    public Employee setData(String Name, String Designation)
    {
        LocalDate d= LocalDate.now();
        Employee employee=new Employee(Name,d,Designation);
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(long parseLong)
    {
        Employee entity=employeeDao.getById(parseLong);
        employeeDao.delete(entity);
    }
}
