package com.employee.employeeData.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long EmployeeId;
    private String EmployeeName;
    private LocalDate JoiningDate;
    private LocalDateTime UpdatedDate;
    private LocalDateTime CreatedDate;
    private String Designation;

    public Employee() {
    }


    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + EmployeeId +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", JoiningDate=" + JoiningDate +
                ", UpdatedDate=" + UpdatedDate +
                ", Designation='" + Designation + '\'' +
                '}';
    }

    public Employee(String employeeName, LocalDate joiningDate, LocalDateTime createdDate, LocalDateTime updatedDate, String designation)
    {
        EmployeeName = employeeName;
        JoiningDate = joiningDate;
        UpdatedDate = updatedDate;
        CreatedDate = createdDate;
        Designation = designation;
    }

    public Employee(String employeeName, LocalDate joiningDate, LocalDateTime updatedDate, String designation) {
        EmployeeName = employeeName;
        JoiningDate = joiningDate;
        UpdatedDate = updatedDate;
        Designation = designation;
    }

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

    public LocalDateTime getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        UpdatedDate = updatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        CreatedDate = createdDate;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
