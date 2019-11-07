package es.upm.pproject.myproject;

import org.junit.jupiter.api.*;

import java.util.Iterator;
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
	public void test200() throws Exception {
		Course course = new Course(5, "lengua", "Guillermo");
		test.registerCourse(course);
		for (int i = 0; i < 50; i++) {
			Student stud = new Student(i, "paco", "paco@email.com");
			test.registerStudent(stud);
			test.addStudentToCourse(stud, course);
		}
		Assertions.assertThrows(Exception.class, () -> {test.addStudentToCourse(new Student(54, "explota", "explota@email.com"), course);});
	}

	@Test
	public void test3() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {new Student(0,"javi", "paco@email.");});
	}

	@Test
	public void test4() {
		Assertions.assertThrows(Exception.class, () -> new Student(0, "", "paco@email.com"));
	}


}
