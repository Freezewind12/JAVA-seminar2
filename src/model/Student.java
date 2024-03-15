package model;

public class Student {
	private long stID;
	private String name;
	private String surname;
	private String persCode;
	
	private static long counter = 1000;
	
	public long getpID() {
		return stID;
	}
	public void setpID() {
		this.stID = counter;
		counter++;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null  && name.matches("[A-Z]{1}[a-z]{1,20}"))
			this.name = name;
		else
			this.name = "Undefinied";
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(surname != null && surname.matches("[A-Z]{1}[a-z]{1,20}"))
			this.surname = surname;
		else
			this.surname = "Undefinied";
	}
	public String getPersCode() {
		return persCode;
	}
	public void setPersCode(String persCode) {
		if(persCode != null  && persCode.matches("[0-9]{5,9}[-]{1}[0-9]{5,9}"))
			this.persCode = persCode;
		else
			this.persCode = "Undefinied";;
	}
	//Constructors
	public Student() {
		setpID();
		setName("Name");
		setSurname("Surname");
		setPersCode("000000-00000");
	}
	
	public Student(String name, String surname, String persCode) {
		setpID();
		setName(name);
		setSurname(surname);
		setPersCode(persCode);
	}
	//4. toString
		@Override
		public String toString()
		{
			return stID + ": " + name + " " + surname + " (" + persCode + ")";
		}
		
}
