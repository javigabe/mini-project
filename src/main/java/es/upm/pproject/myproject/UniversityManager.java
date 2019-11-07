package es.upm.pproject.myproject;

import java.util.*;

public class UniversityManager {

    // Manager for a university
    public UniversityManager() {
    }

    Set<Student> studentSet = new HashSet<>();
    Set<Course> courseSet = new HashSet<>();

    // Method to register a course to the UniversityManager
    public void registerCourse(Course course) throws Exception {
        if (course == null) throw new Exception();
        courseSet.add(course);
    }


    // Method to register a student to the UniversityManager
    public void registerStudent(Student student) throws Exception {
      if (student == null) throw new Exception();
        studentSet.add(student);
    }


    // Method that returns all the students in a course sorted
    public ArrayList<Student> matriculatedStudents(Integer code) throws Exception {
        Course myCourse = null;

        // Pick the course with code "code"
        for (Course course: courseSet) {
            if (course.code.equals(code)) {
                myCourse = course;
                break;
            }
        }
        if (myCourse == null) throw new Exception();
        sort(myCourse.studentsEnrrolled, studComparator);
        return myCourse.studentsEnrrolled;
    }

    // Method that return all the students sorted by a comparator
    public ArrayList<Student> allUsersSorted () {
        ArrayList<Student> studentArrayList = new ArrayList(studentSet);
        sort(studentArrayList, studComparator);
        return studentArrayList;
    }

    // Method that return all the courses sorted by a comparator
    public ArrayList<Course> allCoursesSorted() {
        ArrayList<Course> courseArrayList = new ArrayList(courseSet);
        sort(courseArrayList, courseComparator);
        return courseArrayList;
    }


    public void addStudentToCourse(Student student, Course course) throws Exception {
        if (!courseSet.contains(course) || !studentSet.contains(student)) throw new Exception();

        if (course.students < 50) {
            if (!course.studentsEnrrolled.contains(student)) {
                course.studentsEnrrolled.add(student);
                course.students++;
            }
            else throw new Exception();
        }
        else throw new Exception();

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
