import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	private GradeBook grade1;
	private GradeBook grade2;
	
	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade2= new GradeBook(5);
		grade1.addScore(1);
		grade1.addScore(50);
	
		grade2.addScore(10);
		grade2.addScore(25);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1=null;
		grade2=null;
	}

	@Test
	void testAddScore() {
		assertTrue(grade1.toString().equals("1.0 50.0 "));
		
	}

	@Test
	void testSum() {
		assertEquals(51.0, grade1.sum(), .0001);
		
	}

	@Test
	void testMinimum() {
		assertEquals(1, grade1.minimum(), .0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(50.0, grade1.finalScore(),.0001);
	}

	
	

}
