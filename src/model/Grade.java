package model;

public class Grade {
	private long gID;
	private int value;
	private Student stud;
	private Course course;
	
	private static long counter = 10000;
	
	public long getgID() {
		return gID;
	}
	public void setgID() {
		this.gID = counter;
		counter++;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		if(value > 0 && value < 11) 
			this.value = value;
		else
			this.value = 0;
	}
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		if(stud != null) 
			this.stud = stud;
		else
			this.stud = new Student();
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		if(course != null) 
			this.course = course;
		else
			this.course = new Course();
	}
	//3. constructors
			public Grade() {
				setgID();
				setValue(0);
				setStud(new Student());
				setCourse(new Course());
			}
			
			public Grade(int value, Student stud, Course course) {
				setgID();
				setValue(value);
				setStud(stud);
				setCourse(course);
			}
			

			//4. toString
			@Override
			public String toString()
			{
				return gID + " - " + value + ": " + stud.getSurname() + " (Course: " + course + ")";
			}
	
}
