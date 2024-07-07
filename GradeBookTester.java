import static org.junit.jupiter.api.Assertions.*;	

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	GradeBook g1;
	GradeBook g2;
	@BeforeEach
	void setUp() throws Exception {
		
		g1 = new GradeBook(5);
		g1.addScore(40.0);
		g1.addScore(30.0);

		g2 = new GradeBook(5);
		g2.addScore(80.0);
		g2.addScore(90.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("40.0 30.0 "));
		assertTrue(g2.toString().equals("80.0 90.0 "));
	}

	@Test
	void testSum() {
		assertEquals(70, g1.sum(), .0001);
		assertEquals(170, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(30, g1.minimum(), .001);
		assertEquals(80, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(40.0, g1.finalScore());
		assertEquals(90.0, g2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize());
		assertEquals(2, g2.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue(g1.toString().equals("40.0 30.0 "));
		assertTrue(g2.toString().equals("80.0 90.0 "));
	}

}
