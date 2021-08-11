package managment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeadTest {
	
	private static Head head = null;
	private static Employee emp = null;

	@BeforeEach
	void setUp() throws Exception {
		
		emp= new Employee("Alex", "12");
		head= new Head("John", "Admin");
		emp.setDep("Admin");
	}

	@Test
	void testCreateTask() {
		Task task = new Task(head, emp, "emails");
		head.createTask(task, emp);
		assertTrue(head.tasks.contains(task));
		assertTrue(emp.tasks.contains(task));
	}
	
	@Test
	void testRemoveEmployee() {
		head.removeEmployee("12");
		assertTrue(!head.dep_employees.containsKey("12"));
		
	}
	
	@Test
	void testAddEmployee() {
		head.addEmployee(emp);
		assertTrue(head.dep_employees.containsKey("12"));
		
	}

}
