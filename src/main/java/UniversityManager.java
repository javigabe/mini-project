package main.java;

import java.rmi.server.ExportException;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UniversityManager {
    Set<Student> studentSet;
    Set<Course> courseSet;

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

    public ArrayList<Student> allUsersSorted () {
        ArrayList<Student> studentArrayList = new ArrayList(studentSet);
        sort(studentArrayList, studComparator);
        return studentArrayList;
    }

    public ArrayList<Course> allCoursesSorted() {
        ArrayList<Course> courseArrayList = new ArrayList(courseSet);
        sort(courseArrayList, courseComparator);
        return courseArrayList;
    }


    class Student {

        int studentID;
        String studentName;
        String studentEmail;

        public Student(int id, String name, String email) throws Exception {
            if (!email.matches("*@*[^'.']")) throw new Exception();
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

    class Course {

        Integer code;
        String courseName;
        String coordinator;
        int students = 0;
        ArrayList<Student> studentsEnrrolled = new ArrayList<>();

        public Course(int cod, String name, String coord) {
            code = cod;
            courseName = name;
            coordinator = coord;
            courseSet.add(this);
        }

        private void cancel() {
            studentsEnrrolled = new ArrayList<>();
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
