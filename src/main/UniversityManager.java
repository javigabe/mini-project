package main;

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

        myCourse.sortStudents();

        return myCourse.studentsEnrrolled;
    }

    public ArrayList<Student> allUsers () {
        ArrayList<Student> studentArrayList = new ArrayList(studentSet);


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
            if (course.students < 50) {
                course.studentsEnrrolled.add(this);
                course.students++;
            }
            else throw new Exception();
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
        }

        private void sortStudents() {
            Collections.sort(studentsEnrrolled, codComparator);
        }

        private Comparator<Student> codComparator = new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.studentID-s2.studentID;
            }
        };

        private void cancel() {
            studentsEnrrolled = new ArrayList<>();
            students = 0;
        }
    }

    private void sortStudents (ArrayList<Student> students) {
        
    }




}
