package es.upm.pproject.myproject;

public class Student {

    Integer studentID;
    String studentName;
    String studentEmail;

    public Student(Integer id, String name, String email) throws InvalidEmailException, DataNotFilledException {
        if (name.length() == 0 || id == null) throw new DataNotFilledException();
        if (!check(email)) throw new InvalidEmailException();

        studentID = id;
        studentName = name;
        studentEmail = email;
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
