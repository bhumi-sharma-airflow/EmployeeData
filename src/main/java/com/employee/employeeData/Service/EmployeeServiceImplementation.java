package com.employee.employeeData.Service;

import com.employee.employeeData.Dao.EmployeeDao;
import com.employee.employeeData.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService
{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getData()
    {
        return employeeDao.findAll();
    }

    @Override
    public Optional<Employee> getData(long employeeId)
    {
        return employeeDao.findById(employeeId);
    }

    @Override
    public Employee setData(String Name, String Designation)
    {
        Date d=new Date();
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
