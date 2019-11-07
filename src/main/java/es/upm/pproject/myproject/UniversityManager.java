package es.upm.pproject.myproject;

import java.util.*;

public class UniversityManager {

    // Manager for a university

    Set<Student> studentSet = new HashSet<>();
    Set<Course> courseSet = new HashSet<>();

    // Method to register a course to the UniversityManager
    public void registerCourse(Course course) throws CourseNotFoundException {
        if (course == null) throw new CourseNotFoundException();
        else courseSet.add(course);
    }


    // Method to register a student to the UniversityManager
    public void registerStudent(Student student) throws StudentNotFoundException {
      if (student == null) throw new StudentNotFoundException();
      else studentSet.add(student);
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
        sort(myCourse.studentsEnrrolled, studComparator);
        return myCourse.studentsEnrrolled;
    }

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


    public void addStudentToCourse(Student student, Course course) throws CourseNotFoundException, StudentNotFoundException, CourseFullException {
        if (!courseSet.contains(course)) throw new CourseNotFoundException();
        if (!studentSet.contains(student)) throw new StudentNotFoundException();

        if (course.students < 50) {
            if (!course.studentsEnrrolled.contains(student)) {
                course.studentsEnrrolled.add(student);
                course.students++;
            }
            else throw new Exception();
        }
        else throw new CourseFullException();

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
