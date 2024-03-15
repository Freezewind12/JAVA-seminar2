package service;

import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.Port;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	

	public static void main(String[] args) {	
		Professor pr1 = new Professor();
		Professor pr2 = new Professor("Karine", "Skirmante", Degree.mg);
		Professor pr3 = new Professor("Estere", "Vitole", Degree.mg);
		Professor pr4 = new Professor("Jesus", "Montez", Degree.phd);
		allProfessors.addAll(Arrays.asList(pr1,pr2,pr3,pr4));
		Student st1 = new Student();
		Student st2 = new Student("Igors", "Goncarovs", "291003-21637");
		Student st3 = new Student("Andrii", "Zaporozhec", "3222262-71222");
		Student st4 = new Student("Anton", "Volkov", "1488228-1337666");
		allStudents.addAll(Arrays.asList(st1,st2,st3,st4));
		Course cr1 = new Course();
		Course cr2 = new Course("Java", 4, pr2);
		Course cr3 = new Course("Math analysis", 2, pr4);
		Course cr4 = new Course("LAAG", 2, pr4);
		Course cr5 = new Course("Discrete math", 2, pr4);
		allCourses.addAll(Arrays.asList(cr1,cr2,cr3,cr4,cr5));
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(8, st2, cr3);
		Grade gr3 = new Grade(9, st2, cr4);
		Grade gr4 = new Grade(10, st2, cr5);
		Grade gr5 = new Grade(2, st3, cr3);
		Grade gr6 = new Grade(10, st3, cr4);
		Grade gr7 = new Grade(2, st3, cr5);
		Grade gr8 = new Grade(10, st4, cr3);
		Grade gr9 = new Grade(2, st4, cr4);
		Grade gr10 = new Grade(10, st4, cr5);
		allGrades.addAll(Arrays.asList(gr1,gr2,gr3,gr4,gr5,gr6,gr7,gr8,gr9,gr10));
		
		System.out.println("---------------------------------------");
		
		for(Professor tempProfessor : allProfessors) {
			System.out.println(tempProfessor);
		}
		System.out.println("---------------------------------------");
		for(Student tempStudent : allStudents) {
			System.out.println(tempStudent);
		}
		System.out.println("---------------------------------------");
		for(Course tempCourse : allCourses) {
			System.out.println(tempCourse);
		}
		System.out.println("---------------------------------------");
		for(Grade tempGrade : allGrades) {
			System.out.println(tempGrade);
		}
		System.out.println("---------------------------------------");
		try {
			System.out.println("Average grade for " + st2.getName() + " " + st2.getSurname() + " is "+ CAGforStudents(st2));
			System.out.println("Weighted average grade for " + st2.getName() + " " + st2.getSurname() + " is "+ CAGforStudentsWeighted(st2));
			System.out.println("Average grade for " + cr3.getTitle() + " is "+ CAGforCourse(cr3));
			System.out.println(pr4.getName() + " " + pr4.getSurname() + " leads " + ProfCourseCount(pr4) + " courses");
			System.out.println("There are " + GradeSmaller4(cr5) + " grades lower than 4 in " + cr5.getTitle() + " course");
			System.out.println("There are " + howManyProfHavePHD() + " professors with PhD");
			System.out.println("---------------------------------------");
			sortStudents();
			for(Student tempStudent: allStudents) {
				System.out.println("Average grade for " + tempStudent.getName() + " " + tempStudent.getSurname() + " is "+ CAGforStudents(tempStudent));
			}
			System.out.println("---------------------------------------");
			System.out.println("Retrive student by persCode: " + retriveStudentByPersonCode("291003-21637"));
			System.out.println("Retrive student by persCode: " + retriveStudentByPersonCode("3222262-71222"));
			System.out.println("Retrive student by persCode: " + retriveStudentByPersonCode("1488228-1337666"));
			}
		catch(Exception e) {
		
		System.out.println(e);
		}
	}
	public static float CAGforStudents(Student student) throws Exception {
		if(student == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGrade : allGrades) {
			if (tempGrade.getStud().equals(student)) {
				sum = sum + tempGrade.getValue();
				howMany++;
			}
		}	
		return sum/howMany;
	}
	
	public static float CAGforStudentsWeighted(Student student) throws Exception {
		if(student == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howManyCP = 0;
		
		for(Grade tempGrade : allGrades) {
			if (tempGrade.getStud().equals(student)) {
				sum = sum + tempGrade.getValue() * tempGrade.getCourse().getCreditPoints();
				howManyCP = howManyCP + tempGrade.getCourse().getCreditPoints();
			}
		}	
		return sum/howManyCP;
	}
	public static float CAGforCourse(Course course) throws Exception {
		if(course == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGrade : allGrades) {
			if (tempGrade.getCourse().equals(course)) {
				sum = sum + tempGrade.getValue();
				howMany++;
			}
		}	
		return sum/howMany;
	}
	public static int ProfCourseCount(Professor professor) throws Exception {
		if(professor == null) throw new Exception("Problems with input");
		
		int howMany = 0;
		
		for(Course tempCourse : allCourses) {
			if (tempCourse.getProf().equals(professor)) {
				howMany++;
			}
		}	
		return howMany;
	}
	public static void sortStudents() throws Exception {
		for(int i = 0; i < allStudents.size(); i++) {
			for(int j = 0; j < allStudents.size(); j++) {
				Student tempI = allStudents.get(i);
				Student tempJ = allStudents.get(j);
				if(CAGforStudents(tempJ) < CAGforStudents(tempI)) {
					Student temp = allStudents.get(i);
					allStudents.set(i, allStudents.get(j));
					allStudents.set(j, temp);
					
				}
			}
		}
	}
	public static float GradeSmaller4(Course course) throws Exception {
		if(course == null) throw new Exception("Problems with input");
		
		int howMany = 0;
		
		for(Grade tempGrade : allGrades) {
			if (tempGrade.getCourse().equals(course)) {
				if(tempGrade.getValue() > 4) {
					howMany++;
				}
			}
		}	
		return howMany;
	}
	public static int howManyProfHavePHD() {
		int howMany = 0;
		for(Professor tempPr: allProfessors) {
			if(tempPr.getProfDegree().equals(Degree.phd)) {
				howMany++;
			}
		}
		return howMany;
	}
	public static Student retriveStudentByPersonCode(String persCode) throws Exception{
		if(persCode == null) throw new Exception("Problems with input args");
		for(Student tempSt: allStudents) {
			if(tempSt.getPersCode().equals(persCode)) {
				return tempSt;
			}
		}
		throw new Exception("Student not found");
	}
	public static void createStudent(String name, String surname, String persCode) throws Exception{
		if(name == null || surname == null || persCode == null) throw new Exception("Problems with input args");
		for(Student tempSt: allStudents) {
			if(tempSt.getPersCode().equals(persCode)) {
				throw new Exception("Student is already in the system");
			}
		}
		Student student = new Student(name, surname, persCode);
		allStudents.add(student);
	}
	public static void updateStudentByPersonCode(String name, String surname, String persCode) throws Exception{
		if(name == null || surname == null || persCode == null) throw new Exception("Problems with input args");
		for(Student tempSt: allStudents) {
			if(tempSt.getPersCode().equals(persCode)) {
				tempSt.setName(name);
				tempSt.setSurname(surname);
				return;
			}
		}
		throw new Exception("Student is not found");
	}
}
