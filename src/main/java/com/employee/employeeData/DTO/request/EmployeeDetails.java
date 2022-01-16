package com.employee.employeeData.DTO.request;
public class EmployeeDetails
{
    private long EmployeeId;
    private String EmployeeName;
    private String Designation;

    public EmployeeDetails()
    {
    }

    public long getEmployeeId()
    {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId)
    {
        EmployeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        EmployeeName = employeeName;
    }

    public String getDesignation()
    {
        return Designation;
    }

    public void setDesignation(String designation)
    {
        Designation = designation;
    }
}