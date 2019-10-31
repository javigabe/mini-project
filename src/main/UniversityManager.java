package main;

import java.util.Set;

public class UniversityManager {
    Set<Student> studentSet;
    Set<Course> courseSet;

    class Student {

        int studentID;
        String studentName;
        String studentEmail;

        public Student (int id, String name, String email) throws  Exception{
            if (!email.matches("*@*[^'.']")) throw new Exception();
            studentID = id;
            studentName = name;
            studentEmail = email;
            studentSet.add(this);
        }

        public void addCourse(Course course) throws Exception{
          if (course.students < 50){
            course.studentsEnrrolled.add(this);
            course.students++;
          }
          else {
            throw new Exception();
          }

          public void addCourse(Course course){
          course.studentsEnrrolled.add(this);
          course.students++;
        }

    }

    class Course {

        int code;
        String courseName;
        String coordinator;
        int students = 0;
        Set<Student> studentsEnrrolled;

        public Course(int cod, String name, String coord) {
            code = cod;
            courseName = name;
            coordinator = coord;
            courseSet.add(this);
        }
    }
}
