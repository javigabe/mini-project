package es.upm.pproject.myproject;

import java.util.List;

public interface UniversityManagerInterface {
	
	//Registers a student in the system and checks if student is not null
	public void registerStudent(Student student) throws StudentNotFoundException, StudentAlreadyInManagerException;
	
	//Registers a student in a course and checks if the student and the course are already in the system and if the course is full
    public void addStudentToCourse(Student student, Course course) throws CourseNotFoundException, StudentNotFoundException, CourseFullException, StudentInCourseException;
    
    //Removes a student from a course and checks if the student and the course are already in the system and if the student is enrolled in that course
    public void removeStudentFromCourse(Student student, Course course) throws CourseNotFoundException, StudentNotFoundException;
    
    //Registers a course in the system and checks if the course is not null
    public void registerCourse(Course course) throws CourseNotFoundException, CourseAlreadyInManagerException;
    
    //Returns all the students in a course sorted by the ID, it checks if the course is registered
    public List<Student> matriculatedStudents(Integer code) throws CourseNotFoundException;
    
    //Empty the course if it exists
    public void cancelCourse(Course course) throws CourseNotFoundException;
    
    //Returns all the registered students sorted by ID
    public List<Student> allUsersSorted ();
    
    //Returns all the registered courses sorted by ID
    public List<Course> allCoursesSorted();
    
}
