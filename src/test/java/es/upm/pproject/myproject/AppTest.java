package es.upm.pproject.myproject;

import org.junit.jupiter.api.*;

import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	UniversityManager test;
	
	@BeforeEach
    public void testApp() {
		test = new UniversityManager();
	}
	
	@Test
	public void test1() {
		Assertions.assertEquals(null, test.courseSet);

	}
	
	@Test
	public void test2(){
		Assertions.assertEquals(null, test.studentSet);
	}
	
	@Test
	public void test3(){
		
	}
}
