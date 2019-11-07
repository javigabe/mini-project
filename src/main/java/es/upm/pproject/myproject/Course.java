package es.upm.pproject.myproject;

import java.util.ArrayList;

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
    }

    private void cancel() {
        studentsEnrrolled = new ArrayList<Student>();
        students = 0;
    }
}
