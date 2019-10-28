package main;

public class UniversityManager {

    class Student {

        int studentID;
        String studentName;
        String studentEmail;

        public Student (int id, String name, String email) throws  Exception{
            if (!email.matches("*@*[^'.']")) throw new Exception();
            studentID = id;
            studentName = name;
            studentEmail = email;
        }

    }

    class Course {

        int code;
        String courseName;
        String coordinator;

        public Course(int cod, String name, String coord) {
            code = cod;
            courseName = name;
            coordinator = coord;
        }
    }
}
