package com.employee.employeeData.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long employeeId;
    private String employeeName;
    private LocalDate joiningDate;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;
    private String designation;

    public Employee() {
    }

    public Employee(long employeeId, String employeeName, LocalDate joiningDate, LocalDateTime updatedDate, LocalDateTime createdDate, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.updatedDate = updatedDate;
        this.createdDate = createdDate;
        this.designation = designation;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "EmployeeId=" + this.employeeId +
                ", EmployeeName='" + this.employeeName + '\'' +
                ", JoiningDate=" + this.joiningDate +
                ", UpdatedDate=" + this.updatedDate +
                ", Designation='" + this.designation + '\'' +
                '}';
    }

    public Employee(String employeeName, LocalDate joiningDate, LocalDateTime createdDate, LocalDateTime updatedDate, String designation)
    {
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.updatedDate = updatedDate;
        this.createdDate = createdDate;
        this.designation = designation;
    }

    public Employee(String employeeName, LocalDate joiningDate, LocalDateTime updatedDate, String designation)
    {
        this.employeeName = employeeName;
        this.joiningDate = joiningDate;
        this.updatedDate = updatedDate;
        this.designation = designation;
    }

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

    public LocalDateTime getUpdatedDate()
    {
        return this.updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate)
    {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getCreatedDate()
    {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getDesignation()
    {
        return this.designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }
}