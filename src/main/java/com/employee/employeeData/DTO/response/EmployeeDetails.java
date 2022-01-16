package com.employee.employeeData.DTO.response;

import java.time.LocalDate;

public class EmployeeDetails {
    private long EmployeeId;
    private String EmployeeName;
    private LocalDate JoiningDate;
    private String Designation;

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public LocalDate getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        JoiningDate = joiningDate;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public EmployeeDetails() {
    }
}
