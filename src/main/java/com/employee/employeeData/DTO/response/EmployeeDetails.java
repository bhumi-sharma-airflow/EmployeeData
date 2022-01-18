package com.employee.employeeData.DTO.response;
import java.time.LocalDate;

public class EmployeeDetails
{
    private long employeeId;
    private String employeeName;
    private LocalDate joiningDate;
    private String designation;

    public long getEmployeeId()
    {
        return this.employeeId;
    }
    public void setEmployeeId(long employeeId)
    {
        this.employeeId = employeeId;
    }
    public String getEmployeeName()
    {
        return this.employeeName;
    }
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }
    public LocalDate getJoiningDate()
    {
        return this.joiningDate;
    }
    public void setJoiningDate(LocalDate joiningDate)
    {
        this.joiningDate = joiningDate;
    }
    public String getDesignation()
    {
        return this.designation;
    }
    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public EmployeeDetails(long employeeId, String employeeName, LocalDate joiningDate, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }
}