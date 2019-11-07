package es.upm.pproject.myproject;

public class Student {

    int studentID;
    String studentName;
    String studentEmail;

    public Student(Integer id, String name, String email) throws Exception {
        if (name.length() == 0 || id == null) throw new Exception();
        if (!email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$")) throw new Exception();

        studentID = id;
        studentName = name;
        studentEmail = email;
    }

    public void cancelCourse(Course course) {
        course.studentsEnrrolled.remove(this);
        course.students--;
    }
}
