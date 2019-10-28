package main;

public class UniversityManager {

    class Student {

        int id;
        String name;
        String email;

        public Student (int i, String n, String e){
            id=i;
            name=n;
            email=e;
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
