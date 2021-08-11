package managment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEmployee {
	
	private static Employee emp = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		emp= new Employee();
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetName() {
		emp.setName("James");
		assertEquals(emp.getName(), "James");
		
	}
	
	@Test
	void testSetId() {
		
		emp.setId("12");
		assertEquals(emp.getId(), "12");
		
		
	}
	

	@Test
	void testSetDep() {
		
		emp.setDep("Admin");
		assertEquals(emp.getDep(), "Admin");
		
		
	}
	
	@Test
	void testTask() {
		Head head = new Head("Elise", "Admin");
		Task task = new Task(head, emp, "do work");
		emp.addTask(task);
		
		assertTrue(emp.getTasks().contains(task));
		
		
	}

}
