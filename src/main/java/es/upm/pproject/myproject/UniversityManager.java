package es.upm.pproject.myproject;

import java.util.*;

public class UniversityManager implements UniversityManagerInterface {

    // Manager for a university

    Set<Student> studentSet = new HashSet<>();
    Set<Course> courseSet = new HashSet<>();


    //*********  METHODS OF THE STUDENTS  *********//

    // Method to register a student to the UniversityManager
    public void registerStudent(Student student) throws StudentNotFoundException, StudentAlreadyInManagerException {
        if (student == null) throw new StudentNotFoundException();
        else {
            for (Student student1: studentSet) {
                if (student1.studentID.equals(student.studentID)) throw new StudentAlreadyInManagerException();
            }
            studentSet.add(student);
        }
    }

    // Method to add a student to a course
    public void addStudentToCourse(Student student, Course course) throws CourseNotFoundException, StudentNotFoundException, CourseFullException, StudentInCourseException {
        if (!courseSet.contains(course)) throw new CourseNotFoundException();
        if (!studentSet.contains(student)) throw new StudentNotFoundException();

        if (course.students < 50) {
            if (!course.studentsEnrolled.contains(student)) {
                course.studentsEnrolled.add(student);
                course.students++;
            }
            else throw new StudentInCourseException();
        }
        else throw new CourseFullException();
    }

    // Method to remove a student from a course
    public void removeStudentFromCourse(Student student, Course course) throws CourseNotFoundException, StudentNotFoundException {
        if (!courseSet.contains(course)) throw new CourseNotFoundException();
        if (!studentSet.contains(student) || !course.studentsEnrolled.contains(student)) throw new StudentNotFoundException();

        course.studentsEnrolled.remove(student);
        course.students--;
    }

    //*********  METHODS OF THE COURSES  *********//

    // Method to register a course to the UniversityManager
    public void registerCourse(Course course) throws CourseNotFoundException, CourseAlreadyInManagerException {
        if (course == null) throw new CourseNotFoundException();
        else {
            for (Course course1: courseSet) {
                if (course1.code.equals(course.code)) throw new CourseAlreadyInManagerException();
            }
            courseSet.add(course);
        }
    }

    // Method that returns all the students in a course sorted
    public List<Student> matriculatedStudents(Integer code) throws CourseNotFoundException {
        Course myCourse = null;

        // Pick the course with code "code"
        for (Course course: courseSet) {
            if (course.code.equals(code)) {
                myCourse = course;
                break;
            }
        }
        if (myCourse == null) throw new CourseNotFoundException();
        sort(myCourse.studentsEnrolled, studComparator);
        return myCourse.studentsEnrolled;
    }
    // Methot that empty a course
    public void cancelCourse(Course course) throws CourseNotFoundException {
        if (!courseSet.contains(course)) throw new CourseNotFoundException();

        course.studentsEnrolled = new ArrayList<>();
        course.students = 0;
    }


    //*********  METHODS OF THE MANAGER  *********//

    // Method that return all the students sorted by a comparator
    public List<Student> allUsersSorted () {
        ArrayList<Student> studentArrayList = new ArrayList<>(studentSet);
        sort(studentArrayList, studComparator);
        return studentArrayList;
    }

    // Method that return all the courses sorted by a comparator
    public List<Course> allCoursesSorted() {
        ArrayList<Course> courseArrayList = new ArrayList<>(courseSet);
        sort(courseArrayList, courseComparator);
        return courseArrayList;
    }


    // Auxiliar methods

    private void sort(ArrayList list, Comparator comp) {
        Collections.sort(list, comp);
    }

    private Comparator<Student> studComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            return s1.studentID-s2.studentID;
        }
    };

    private Comparator<Course> courseComparator = new Comparator<Course>() {
        public int compare(Course s1, Course s2) {
            return s1.code-s2.code;
        }
    };
}
