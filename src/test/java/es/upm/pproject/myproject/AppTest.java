package es.upm.pproject.myproject;

import org.junit.jupiter.api.*;

import java.util.HashSet;
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
	private UniversityManager test;

	@BeforeEach
    public void testApp() {
		test = new UniversityManager();
	}

	@Test
	public void test1() {
		Assertions.assertEquals(new HashSet<>(), test.courseSet);

	}

	@Test
	public void test2(){
		Assertions.assertEquals(new HashSet<>(), test.studentSet);
	}

	@Test
	public void test3() throws Exception {
		Assertions.assertThrows(InvalidEmailException.class, () -> {new Student(0,"Javi", "jaco@email.");});
	}

	@Test
	public void test4() {
		Assertions.assertThrows(DataNotFilledException.class, () -> new Student(0, "", "paco@email.com"));
	}

	@Test
	public void test5() {
		Assertions.assertThrows(DataNotFilledException.class, () -> new Student(null, "Alvaro", "alvaro@email.es"));
	}
	
	@Test
	public void test6() throws InvalidEmailException, DataNotFilledException, StudentNotFoundException {
		Student student =  new Student(10, "Alvaro", "alvaro@email.es");
		test.registerStudent(student);
		Course course = new Course(21, "programming_project", "Guillermo");
		Assertions.assertThrows(CourseNotFoundException.class, () -> test.addStudentToCourse(student, course));
	}
	

/*	@Test
	public void test200() throws Exception {
		Course course = new Course(5, "lengua", "Guillermo");
		test.registerCourse(course);
		for (int i = 0; i < 50; i++) {
			Student stud = new Student(i, "paco", "paco@email.com");
			test.registerStudent(stud);
			test.addStudentToCourse(stud, course);
		}
		Student stud = new Student(54, "explota", "explota@email.com");

		Assertions.assertThrows(Exception.class, () -> {test.addStudentToCourse(stud, course);});
	}*/


}
