package es.upm.pproject.myproject;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
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

	@Test
	public void test7() throws InvalidEmailException, DataNotFilledException, CourseNotFoundException {
		Student student =  new Student(10, "Alvaro", "alvaro@email.es");
		Course course = new Course(21, "programming project", "Guillermo");
		test.registerCourse(course);
		Assertions.assertThrows(StudentNotFoundException.class, () -> test.addStudentToCourse(student, course));
	}

	@Test
	public void test8() throws Exception {
		Course course = new Course(5, "programming project", "Guillermo");
		test.registerCourse(course);
		for (int i = 0; i < 50; i++) {
			Student student = new Student(i, "paco", "paco@email.com");
			test.registerStudent(student);
			test.addStudentToCourse(student, course);
		}
		Student student = new Student(54, "explota", "explota@email.com");
		test.registerStudent(student);
		Assertions.assertThrows(CourseFullException.class, () -> {test.addStudentToCourse(student, course);});
	}

	@Test
	public void test9() throws DataNotFilledException, CourseNotFoundException, InvalidEmailException, StudentNotFoundException, CourseFullException {
		Course course = new Course(5, "programming project", "Guillermo");
		test.registerCourse(course);
		Student student =  new Student(10, "Alvaro", "alvaro@email.es");
		test.registerStudent(student);
		test.addStudentToCourse(student, course);
		Assertions.assertFalse(course.studentsEnrrolled.contains(student));
	}

	@Test
	public void test10() throws DataNotFilledException, CourseNotFoundException, InvalidEmailException, StudentNotFoundException, CourseFullException{
		Course course = new Course(5, "programming project", "Guillermo");
		test.registerCourse(course);
		Student student =  new Student(10, "Alvaro", "alvaro@email.es");
		test.registerStudent(student);
		test.addStudentToCourse(student, course);
		Assertions.assertTrue(course.cancel());
	}

	@Test
	public void test11() throws DataNotFilledException, CourseNotFoundException, InvalidEmailException, StudentNotFoundException, CourseFullException {
		Course course = new Course(5, "programming project", "Guillermo");
		test.registerCourse(course);

		Student student1 =  new Student(1, "Alvaro", "alvaro@email.es");
		test.registerStudent(student1);
		test.addStudentToCourse(student1, course);

		Student student2 =  new Student(3, "Javier", "javier@email.es");
		test.registerStudent(student2);
		test.addStudentToCourse(student2, course);

		Student student3 =  new Student(2, "Mario", "mario@email.es");
		test.registerStudent(student3);
		test.addStudentToCourse(student3, course);

		ArrayList<Student> studentsEnrrolled = new ArrayList<>();
		studentsEnrrolled.add(student1);
		studentsEnrrolled.add(student3);
		studentsEnrrolled.add(student2);

		ArrayList<Student> sortStudents = (ArrayList<Student>) test.matriculatedStudents(5);

		Assertions.assertEquals(studentsEnrrolled, sortStudents);
	}

	@Test
	public void test12() throws DataNotFilledException {
		Assertions.assertThrows(CourseNotFoundException.class, () -> {test.matriculatedStudents(5);});
	}

	@Test
	public void test13() throws InvalidEmailException, DataNotFilledException, StudentNotFoundException {
		Student student1 =  new Student(1, "Alvaro", "alvaro@email.es");
		test.registerStudent(student1);

		Student student2 =  new Student(3, "Javier", "javier@email.es");
		test.registerStudent(student2);

		Student student3 =  new Student(2, "Mario", "mario@email.es");
		test.registerStudent(student3);

		ArrayList<Student> studentsEnrrolled = new ArrayList<>();
		studentsEnrrolled.add(student1);
		studentsEnrrolled.add(student3);
		studentsEnrrolled.add(student2);

		ArrayList<Student> sortStudents = (ArrayList<Student>) test.allUsersSorted();

		Assertions.assertEquals(studentsEnrrolled, sortStudents);
	}
}
