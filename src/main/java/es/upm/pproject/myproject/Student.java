package es.upm.pproject.myproject;

public class Student {

    int studentID;
    String studentName;
    String studentEmail;

    public Student(Integer id, String name, String email) throws Exception {
        if (name.length() == 0 || id == null) throw new Exception();
        if (check(email)) throw new Exception();

        studentID = id;
        studentName = name;
        studentEmail = email;
    }

    public boolean cancelCourse(Course course) {
        course.studentsEnrrolled.remove(this);
        course.students--;
        return true;
    }

    private boolean check(String email) {
		boolean containsArr = false;

		for(int n = 0; n < email.length(); n++) {
			char c = email.charAt(n);
			if(c == '@')
				containsArr = true;
		}
		return containsArr && (email.charAt(email.length()-1) != '.');
	}
}
