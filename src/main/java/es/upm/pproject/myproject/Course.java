package es.upm.pproject.myproject;

import java.util.ArrayList;

public class Course {

    Integer code;
    String courseName;
    String coordinator;
    int students;
    ArrayList<Student> studentsEnrolled = new ArrayList<>();

    public Course(Integer cod, String name, String coord) throws DataNotFilledException {
        if (name.length() == 0 || coord.length() == 0 || cod == null) throw new DataNotFilledException();

        code = cod;
        courseName = name;
        coordinator = coord;
        students = 0;
    }
}
