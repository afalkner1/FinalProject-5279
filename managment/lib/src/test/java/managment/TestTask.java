package managment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTask {
	private static Task task = null;
	private static Head head = null;
	private static Employee emp = null;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		head = new Head("John", "Admin");
		emp = new Employee("Alex", "12");
		
		task = new Task(head, emp, "email people");
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
	void testget() {
		assertEquals(task.getInfo(), "email people");
		assertEquals(task.getHead(), head);
		assertEquals(task.getEmployee(), emp);
	}

}
