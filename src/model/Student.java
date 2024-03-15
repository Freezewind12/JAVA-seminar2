package model;
public class Student extends Person{
	private long stID;
	
	private static long counter = 1000;
	
	public long getpID() {
		return stID;
	}
	public void setpID() {
		this.stID = counter;
		counter++;
	}
	//Constructors
	public Student() {
		super();
		setpID();
		
	}
	
	public Student(String name, String surname, String persCode) {
		super(name, surname, persCode); //Person constructor will be used
		setpID();
	}
	//4. toString
		@Override
		public String toString()
		{
			return stID + ": " + super.toString();
		}
		
}
