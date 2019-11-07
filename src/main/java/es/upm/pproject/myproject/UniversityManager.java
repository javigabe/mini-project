package es.upm.pproject.myproject;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UniversityManager {
    // Manager for a university
    Set<Student> studentSet;
    Set<Course> courseSet;

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


    // Method to register a course
    public void registerCourse(int cod, String name, String coord) throws Exception {
        new Course(cod, name, coord);
    }

    // Method to register a student
    public void registerStudent(int id, String name, String email) throws Exception {
        new Student(id, name, email);
    }


    // Student class with its own methods
    class Student {

        int studentID;
        String studentName;
        String studentEmail;

        public Student(Integer id, String name, String email) throws Exception {
            if (name.length() == 0 || id == null) throw new Exception();
            //if (!email.matches("*@*[^'.']")) throw new Exception();

            studentID = id;
            studentName = name;
            studentEmail = email;
            studentSet.add(this);
        }

        public void addCourse(Course course) throws Exception {
            if (!courseSet. contains(course)) throw new Exception();

            if (course.students < 50) {
                if (!course.studentsEnrrolled.contains(this)) {
                    course.studentsEnrrolled.add(this);
                    course.students++;
                }
                else throw new Exception();
            }
            else throw new Exception();
        }

        public void cancelCourse(Course course) {
            course.studentsEnrrolled.remove(this);
            course.students--;
        }
    }

    // Course class with its own methods
    class Course {

        Integer code;
        String courseName;
        String coordinator;
        int students = 0;
        ArrayList<Student> studentsEnrrolled = new ArrayList<Student>();

        public Course(Integer cod, String name, String coord) throws Exception {
            if (name.length() == 0 || coord.length() == 0 || cod == null) throw new Exception();

            code = cod;
            courseName = name;
            coordinator = coord;
            courseSet.add(this);
        }

        private void cancel() {
            studentsEnrrolled = new ArrayList<Student>();
            students = 0;
        }
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
