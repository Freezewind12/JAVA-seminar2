package service;

import java.util.ArrayList;
import java.util.Arrays;

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
		Professor pr3 = new Professor("Estere", "Vitol", Degree.mg);
		allProfessors.addAll(Arrays.asList(pr1,pr2,pr3));
		Student st1 = new Student();
		allStudents.add(st1);
		Student st2 = new Student("Igors", "Goncarovs");
		allStudents.addAll(Arrays.asList(st1,st2));
		Course cr1 = new Course();
		Course cr2 = new Course("Java", 4, pr2);
		allCourses.addAll(Arrays.asList(cr1,cr2));
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(10, st2, cr2);
		allGrades.addAll(Arrays.asList(gr1,gr2));
		
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
			System.out.println("Average grade for " + st2.getName() + " " + st2.getSurname() + " is "+ CalculateAverageGradeForStudents(st2));
			}
		catch(Exception e) {
		
		System.out.println(e);
		}
	}
	public static float CalculateAverageGradeForStudents(Student student) throws Exception {
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
}
