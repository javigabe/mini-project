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
	public void test3() throws Exception {
		/*test.registerCourse(1, "lengua", "pepe");

		UniversityManager.Course course = test.courseSet.iterator().next();

		for (int i = 0; i < 50; i++) {
			test.registerStudent(i, "pepe", "@");
		}


		for (UniversityManager.Student student: test.studentSet) {
			student.addCourse(course);
		}

		UniversityManager.Student student = null;

		test.registerStudent(52, "paco", "@");
		Iterator it = test.studentSet.iterator();

		while (it.hasNext()) {
			 student = (UniversityManager.Student) it.next();
		}

		UniversityManager.Student finalStudent = student;
		Assertions.assertThrows(Exception.class, () -> {
			finalStudent.addCourse(course);});*/

	}

	@Test
	public void test4() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {new Student(0,"javi", "pacoemail");});
	}

	@Test
	public void test5() {
		//Assertions.assertThrows(Exception.class, () -> test.registerStudent(0, "pepe", "af"));
	}


}
