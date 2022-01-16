package com.employee.employeeData.DTO.request;
public class EmployeeDetails
{
    private long employeeId;
    private String employeeName;
    private String designation;

    public EmployeeDetails()
    {
    }

    public long getEmployeeId()
    {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId)
    {
        this.employeeId=employeeId;
    }

    public String getEmployeeName()
    {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getDesignation()
    {
        return this.designation;
    }

    public void setDesignation(String designation)
    {
        this.designation=designation;
    }
}