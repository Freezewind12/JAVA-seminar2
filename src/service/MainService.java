package service;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		Professor pr1 = new Professor();
		System.out.println(pr1);
		Professor pr2 = new Professor("Karine", "Skirmante", Degree.mg);
		System.out.println(pr2);
		Professor pr3 = new Professor("Estere", "Vitol", Degree.mg);
		System.out.println(pr3);
		Student st1 = new Student();
		System.out.println(st1);
		Student st2 = new Student("Igors", "Goncarovs");
		System.out.println(st2);
		Course cr1 = new Course();
		System.out.println(cr1);
		Course cr2 = new Course("Java", 4, pr2);
		System.out.println(cr2);
		Grade gr1 = new Grade();
		System.out.println(gr1);
		Grade gr2 = new Grade(10, st2, cr2);
		System.out.println(gr2);
		
	}

}
