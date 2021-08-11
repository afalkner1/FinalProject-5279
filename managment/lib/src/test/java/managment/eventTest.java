package managment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class eventTest {
	
	private static Event eve = null;
	private static Event eve2 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		eve = new Event();
		eve2 = new Event();
	}


	@Test
	void testOverlap() {
		eve.setStart(2021, 4, 13, 6, 30);
		eve.setEnd(2021, 4, 20, 5, 30);
		
		eve2.setStart(2021, 4, 14, 6, 30);
		eve2.setEnd(2021, 4, 20, 5, 30);
		
		assertTrue(eve.overlap(eve2));
		
		
		eve2.setStart(2021, 4, 10, 6, 30);
		eve2.setEnd(2021, 4, 15, 5, 30);
		
		assertTrue(eve.overlap(eve2));
		
		eve2.setStart(2021, 4, 14, 6, 30);
		eve2.setEnd(2021, 4, 17, 5, 30);
		
		assertTrue(eve.overlap(eve2));
	
	}

}
