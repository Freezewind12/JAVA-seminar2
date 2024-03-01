package model;

public class Course {
	private long cID;
	private String title;
	private int creditPoints;
	private Professor prof;
	
private static long counter = 2000;
	
	public long getcID() {
		return cID;
	}
	public void setcID() {
		this.cID = counter;
		counter++;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title != null  && title.matches("[A-Za-z 0-9]{4,40}")) 
			this.title = title;
		else
			this.title = "Undefinied";
	}
	public int getCreditPoints() {
		return creditPoints;
	}
	public void setCreditPoints(int creditPoints) {
		if(creditPoints != 0 && creditPoints < 21) 
			this.creditPoints = creditPoints;
		else
			this.creditPoints = 0;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		if(prof != null) 
			this.prof = prof;
		else
			this.prof = new Professor();
	}
	//3. constructors
		public Course() {
			setcID();
			setTitle("NaNd");
			setCreditPoints(0);
			setProf(new Professor());
		}
		
		public Course(String title, int creditPoint, Professor prof) {
			setcID();
			setTitle(title);
			setCreditPoints(creditPoint);
			setProf(prof);
		}
		

		//4. toString
		@Override
		public String toString()
		{
			return cID + " - " + title + ": " + creditPoints + " cp(Lecturer: " + prof.getSurname() + ")";
		}
}
