package managment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeetingTest {
	
	private static Meeting meet = null;
	private static Employee emp = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		meet = new Meeting("London");
		emp = new Employee("John", "Admin");
	}


	@Test
	void testAdd() {
		meet.addPeople(emp);
		assertTrue(meet.attendees.contains(emp));
	}

}
