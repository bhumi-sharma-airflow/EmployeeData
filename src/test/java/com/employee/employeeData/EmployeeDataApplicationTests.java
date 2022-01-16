//package com.employee.employeeData;
//
//import com.employee.employeeData.Dao.EmployeeDao;
//import com.employee.employeeData.Entities.Employee;
//import com.employee.employeeData.Service.EmployeeService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.time.LocalDate;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeDataApplicationTests
//{
//	@Mock
//	private EmployeeDao employeeDao;
//
//	@InjectMocks
//	private EmployeeService employeeService;
//
//	@Test
//	public void givenEmployeeId_WhenDeleteRequestisRaise_thanIfshouldBeDeletedFromDatabase()
//	{
//		long employeeResigned=5;
//		employeeService.deleteEmployee(employeeResigned);
//	}
//}
