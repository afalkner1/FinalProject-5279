package managment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar; 
import java.util.Date;


public class DatabaseTest {
	
	private static Database data = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {	
		
		data = new Database();
		
	}


	@Test
	public void testAddEmployee() {
	
		
		data.addEmployee("john", "10");
		
		assertTrue(data.employees.containsKey("10"));
		
		Employee emp = data.employees.get("10");
		
		assertEquals(emp.getName(), "john");
		
//		Test setName 
		
		data.employees.get("10").setName("alex");
		
		emp = data.employees.get("10");
		
		assertEquals(emp.getName(), "alex");
		

			
	}
	
	@Test
	public void testAddHead() {
		
		
		
		data.addHead("James", "Admin");
		
		assertTrue(data.heads.containsKey("Admin"));
		
		Head head = data.heads.get("Admin");
		
		assertEquals(head.getName(), "James");
		
	}
	
	@Test 
	public void testCreateTask() {
		
		
		Employee emp = data.employees.get("10");
		Head head = data.heads.get("Admin");
		
		Task task = data.createTask("Admin", "10", "do work");
		
		assertTrue(data.tasks.contains(task));
		
		emp = data.employees.get("10");
		
		head = data.heads.get("Admin");
		
		assertTrue(emp.tasks.contains(task));
		assertTrue(head.tasks.contains(task));
		
		assertEquals(task.getInfo(), "do work");
		assertEquals(task.getHead(), head);
		assertEquals(task.getEmployee(), emp);
		
		task.setEnd(2021,10, 23, 12, 34);
		
		Calendar cal = Calendar.getInstance();	
		cal.set(2021,10, 23, 12, 34);
		
		assertTrue(cal.getWeekYear() == task.end_time.getWeekYear());
		
	}
	
	@Test
	public void testAddDep() {
		
	
		
		
		data.setDep("10", "Admin");
		
		assertEquals(data.employees.get("10").getDep(), "Admin");
		
		// adding employee without dep 		
		
		data.addEmployee("Annie", "20");
		
		data.setDep("20", "Sales");
		
		data.addHead("Elise", "Sales");
		
		Head head = data.heads.get("Sales");
		
		assertTrue(head.dep_employees.containsKey("20"));
		
		
	}
	
	@Test 
	public void testRequestLeave() {
				
		
		data.printEmployees();
		
		data.addHead("Mike", "Marketing");
		
		data.addEmployee("Lola", "13");
		
		data.setDep("13", "Marketing");
		
		Event eve = new Event();
		
		eve.setEnd(2021, 10, 21, 6, 30);
		eve.setStart(2021, 9, 21, 7, 30);
		
		
		data.requestLeave("13", eve);
		
		assertTrue(data.employees.get("13").leave_calendar.contains(eve));
		assertTrue(data.heads.get("Marketing").emp_leave_calendar.contains(eve));
	
		data.addEmployee("James","15");
		
		assertTrue(data.employees.containsKey("15"));
		
		Employee emp = data.employees.get("15");
		
		assertEquals(emp.getName(), "James");
		
		data.setDep("15", "Marketing");
		
		assertEquals(data.employees.get("15").getDep(), "Marketing");
		
				
		data.requestLeave("15", eve);
		
		assertTrue(!data.employees.get("15").leave_calendar.contains(eve));
		assertTrue(data.heads.get("Marketing").emp_leave_calendar.size() == 1);
		
		
		Event eve1 = new Event();
		
		
		eve1.setStart(2021, 9, 15, 7, 30); 
		eve1.setEnd(2021, 10, 20, 6, 30);
		
		
		data.requestLeave("15", eve1);
		
		assertTrue(!data.employees.get("15").leave_calendar.contains(eve1));
		assertTrue(data.heads.get("Marketing").emp_leave_calendar.size() == 1);
		
		
		eve1.setStart(2021, 9, 23, 7, 30); 
		eve1.setEnd(2021, 10, 23, 6, 30);
		
		
		data.requestLeave("15", eve1);
		
		assertTrue(!data.employees.get("15").leave_calendar.contains(eve1));
		assertTrue(data.heads.get("Marketing").emp_leave_calendar.size() == 1);
		
		eve1.setStart(2021, 9, 23, 7, 30); 
		eve1.setEnd(2021, 10, 17, 6, 30);
		
		
		data.requestLeave("15", eve1);
		
		assertTrue(!data.employees.get("15").leave_calendar.contains(eve1));
		assertTrue(data.heads.get("Marketing").emp_leave_calendar.size() == 1);
		
		
		eve1.setStart(2021, 10, 23, 7, 30); 
		eve1.setEnd(2021, 10, 30, 6, 30);
		
		
		data.requestLeave("15", eve1);
		
		assertTrue(data.employees.get("15").leave_calendar.contains(eve1));
		assertTrue(data.heads.get("Marketing").emp_leave_calendar.size() == 2);			
		
	}
	
	@Test 
	public void testMeeting() {
		
		data.createMeeting("france");
		
		data.setMeetingStartTime("france", 2021, 9, 4, 6, 30);
		data.setMeetingEndTime("france", 2021, 9, 4, 7, 30);
		
		data.addPeopletoMeeting("15", "france");
		data.addPeopletoMeeting("Admin", "france");
		
		assertTrue(data.meetings.containsKey("france"));
		assertTrue(data.meetings.get("france").attendees.contains(data.employees.get("15")));
		assertTrue(data.meetings.get("france").attendees.contains(data.heads.get("Admin")));
		
		assertTrue(data.all_employees.get("15").meetings.containsKey("france"));
		assertTrue(data.all_employees.get("Admin").meetings.containsKey("france"));
		
		data.createMeeting("london");
		
//		create meeting at the same time -- it should not add to people's calendars
		
		data.setMeetingStartTime("london", 2021, 9, 4, 6, 30);
		data.setMeetingEndTime("london", 2021, 9, 4, 7, 30);
		
		data.addPeopletoMeeting("15", "london");
		
	
		assertTrue(!data.meetings.get("london").attendees.contains(data.employees.get("15")));
		assertTrue(!data.meetings.get("london").attendees.contains(data.heads.get("Admin")));
		
		assertTrue(!data.all_employees.get("15").meetings.containsKey("london"));
		assertTrue(!data.all_employees.get("Admin").meetings.containsKey("london"));		
		
		
	}
	
	@Test
	public void testPromote() {
		data.promoteEmployee("13", "Sales");
		
		assertTrue(data.heads.containsKey("Sales"));
		
		Head head = data.heads.get("Sales");
		
		assertEquals(head.getName(), "Lola");
		
		assertTrue(!data.employees.containsKey("13"));
		
				
		
	}
		

}
