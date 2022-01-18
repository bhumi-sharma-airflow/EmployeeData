package com.employee.employeeData;
import com.employee.employeeData.DTO.response.EmployeeDetails;
import com.employee.employeeData.Dao.EmployeeDao;
import com.employee.employeeData.Entities.Employee;
import com.employee.employeeData.Service.EmployeeServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeDataApplicationTests
{
	@Mock
	private EmployeeDao employeeDao;

	@InjectMocks
	private EmployeeServiceImplementation employeeServiceImplementation;

    @Test
    public void givenGetId()
    {
        long employeeId=2;
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime =LocalDateTime.now();
        Employee employee = new Employee("Bhumi",date,dateTime,dateTime,"Job");
        employee.setEmployeeId(employeeId);

        EmployeeDetails employeeDetails = new EmployeeDetails(employee.getEmployeeId(), employee.getEmployeeName(), employee.getJoiningDate(), employee.getDesignation());
        employeeDetails.setEmployeeId(employeeId);
        employeeDetails.setEmployeeName("Bhumi");
        employeeDetails.setJoiningDate(date);
        employeeDetails.setDesignation("Job");

        ResponseEntity<EmployeeDetails> excepted = ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
        when(employeeDao.existsById(employeeId)).thenReturn(true);
        when(employeeDao.getById(employeeId)).thenReturn(employee);

        ResponseEntity<EmployeeDetails> actual = employeeServiceImplementation.getData(employeeId);

        assertEquals(actual.getBody().getEmployeeId(),excepted.getBody().getEmployeeId());
        assertEquals(actual.getBody().getEmployeeName(),excepted.getBody().getEmployeeName());
        assertEquals(actual.getBody().getDesignation(),excepted.getBody().getDesignation());
        assertEquals(actual.getBody().getJoiningDate(),excepted.getBody().getJoiningDate());
    }

	@Test
	public void givenEmployeeId_WhenDeleteRequestisRaise_thanItshouldBeDeletedFromDatabase()
	{
		long employeeResignedId=5;

        ArgumentCaptor<Long> employeeIdCapturer = ArgumentCaptor.forClass(Long.class);

        when(employeeDao.existsById(employeeResignedId)).thenReturn(true);

        employeeServiceImplementation.deleteEmployee(employeeResignedId);
        verify(employeeDao,times(1)).getById(employeeIdCapturer.capture());

        assertEquals(employeeResignedId, employeeIdCapturer.getValue());
	}

    @Test
    public void givenNewName_WhenupdateEmployeeRaise_ThenItShoulBeUpdatedInDatabase()
    {
        long employeeId =1;
        com.employee.employeeData.DTO.request.EmployeeDetails employeeDetails =new com.employee.employeeData.DTO.request.EmployeeDetails();
        employeeDetails.setEmployeeId(1);
        employeeDetails.setEmployeeName("abc");
        employeeDetails.setDesignation("job");
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime =LocalDateTime.now();
        Employee employee = new Employee("het",date,dateTime,dateTime,"job");
        employee.setEmployeeId(employeeId);
        ArgumentCaptor<Employee> employee1 = ArgumentCaptor.forClass(Employee.class);
        when(employeeDao.existsById(employeeId)).thenReturn(true);
        when(employeeDao.getById(employeeId)).thenReturn(employee);
        ResponseEntity<String> actual = employeeServiceImplementation.updateData(employeeDetails);
        verify(employeeDao,times(1)).save(employee1.capture());
        ResponseEntity<String> expected= ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
        assertEquals(expected,actual);
    }

    @Test
    public void givenNewData_WhenAddEmployeeRaise_ThenItShoulBeAddedInDatabase()
    {
        com.employee.employeeData.DTO.request.EmployeeDetails employeeDetailsObj=new com.employee.employeeData.DTO.request.EmployeeDetails();
        employeeDetailsObj.setEmployeeName("Bhumi");
        employeeDetailsObj.setDesignation("Job");
        LocalDateTime createdDate= LocalDateTime.now();
        LocalDateTime updatedDate= LocalDateTime.now();
        LocalDate joiningDate=LocalDate.now();
        Employee employee=new Employee("Bhumi",joiningDate,createdDate,updatedDate,"job");
        when(employeeDao.save(any())).thenReturn(employee);
        EmployeeDetails employeeDetailsActual=new EmployeeDetails(employee.getEmployeeId(), employee.getEmployeeName(), employee.getJoiningDate(), employee.getDesignation());
        employeeDetailsActual.setEmployeeName("Bhumi");
        employeeDetailsActual.setDesignation("job");
        employeeDetailsActual.setJoiningDate(joiningDate);
        EmployeeDetails employeeDetailsexcepted=employeeServiceImplementation.setData(employeeDetailsObj);
        assertEquals(employeeDetailsexcepted.getEmployeeId(),employeeDetailsActual.getEmployeeId());
        assertEquals(employeeDetailsexcepted.getEmployeeName(),employeeDetailsActual.getEmployeeName());
        assertEquals(employeeDetailsexcepted.getDesignation(),employeeDetailsActual.getDesignation());
    }

    @Test
    public void page()
    {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime =LocalDateTime.now();

        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(new Employee(1,"Bhumi",date, dateTime, dateTime,"Job"));
        employeeList.add(new Employee(2,"Komal",date, dateTime, dateTime,"Intern"));
        employeeList.add(new Employee(3,"Meet",date, dateTime, dateTime,"Job"));
        employeeList.add(new Employee(4,"Aman",date, dateTime, dateTime,"Job"));

        List<EmployeeDetails> employeeDetailsList=new LinkedList<>();

        for(Employee employee:employeeList)
        {
            EmployeeDetails employeeDetails=new EmployeeDetails(employee.getEmployeeId(),employee.getEmployeeName(),employee.getJoiningDate(),employee.getDesignation());
            employeeDetailsList.add(employeeDetails);
        }
        int page = 5;
        Pageable firstFiveEmployees = PageRequest.of(page, 3);
        Page<Employee> employeePage = new PageImpl<>(employeeList);

        when(employeeDao.findAll(firstFiveEmployees)).thenReturn(employeePage);

        List<EmployeeDetails> employeeDetailsResponseEntity = employeeServiceImplementation.getData(page);
        List<EmployeeDetails> expectedEmployeeDetails = employeeDetailsList;

        ArgumentCaptor<EmployeeDetails> employeeArgumentCaptor = ArgumentCaptor.forClass(EmployeeDetails.class);
        verify(employeeDao,times(1)).findAll((Pageable) employeeArgumentCaptor.capture());

        for(int i=0;i<4;i++)
        {
            assertEquals(expectedEmployeeDetails.get(i).getEmployeeId(), employeeDetailsResponseEntity.get(i).getEmployeeId());
            assertEquals(expectedEmployeeDetails.get(i).getEmployeeName(), employeeDetailsResponseEntity.get(i).getEmployeeName());
            assertEquals(expectedEmployeeDetails.get(i).getJoiningDate(), employeeDetailsResponseEntity.get(i).getJoiningDate());
            assertEquals(expectedEmployeeDetails.get(i).getDesignation(), employeeDetailsResponseEntity.get(i).getDesignation());
        }
    }

    @Test
    public void test()
    {
        Employee employee=new Employee();
        employee.setEmployeeName("Bhumi");
        when(employeeDao.findById(2l)).thenReturn(Optional.of(employee));
        employeeDao.findById(2l);
    }
}
