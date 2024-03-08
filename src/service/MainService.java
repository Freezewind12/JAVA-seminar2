package service;

import java.util.ArrayList;

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
		System.out.println(pr1);
		allProfessors.add(pr1);
		Professor pr2 = new Professor("Karine", "Skirmante", Degree.mg);
		System.out.println(pr2);
		allProfessors.add(pr2);
		Professor pr3 = new Professor("Estere", "Vitol", Degree.mg);
		System.out.println(pr3);
		allProfessors.add(pr3);
		Student st1 = new Student();
		allStudents.add(st1);
		System.out.println(st1);
		Student st2 = new Student("Igors", "Goncarovs");
		System.out.println(st2);
		allStudents.add(st2);
		Course cr1 = new Course();
		System.out.println(cr1);
		allCourses.add(cr1);
		Course cr2 = new Course("Java", 4, pr2);
		System.out.println(cr2);
		allCourses.add(cr2);
		Grade gr1 = new Grade();
		System.out.println(gr1);
		allGrades.add(gr1);
		Grade gr2 = new Grade(10, st2, cr2);
		System.out.println(gr2);
		allGrades.add(gr2);
		
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
		
	}
}
