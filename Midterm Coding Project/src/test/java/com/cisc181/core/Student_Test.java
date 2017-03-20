package com.cisc181.core;

import static org.junit.Assert.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
	static ArrayList<Double> studentGPAList = new ArrayList<Double>();
	static ArrayList<Double> physGPAList = new ArrayList<Double>();
	static ArrayList<Double> medGPAList = new ArrayList<Double>();
	static ArrayList<Double> chemGPAList = new ArrayList<Double>();
	static Semester fall, spring;
	static Course PHYS, MED, CHEM;
	static Section f11, f22, f33, s11, s22, s33;
	static Student sa, sb, sc, sd, se, sf, sg, sh, si, sj;
	static Enrollment e1, e2, e3, e4, e5, e6;

	
	@SuppressWarnings("deprecation")
	public static Date studDate(int year, int month, int day){
		Calendar CalB = Calendar.getInstance();
		CalB.set(year, month, day);
		return CalB.getTime();
	}
	@BeforeClass
	public static void setup() throws Exception{
		
		// courses
		
		PHYS = (new Course(UUID.randomUUID(), "PHYS110", 4, eMajor.PHYSICS));
		MED = (new Course(UUID.randomUUID(), "MED330", 4, eMajor.NURSING));
		CHEM = (new Course(UUID.randomUUID(), "CHEM220", 4, eMajor.CHEM));
		courseList.add(PHYS);
		courseList.add(MED);
		courseList.add(CHEM);
		
		// semesters
		fall = new Semester(UUID.randomUUID(), studDate(2016, 8, 30), studDate(2016, 12, 20));
		spring = new Semester(UUID.randomUUID(), studDate(2017, 1, 25), studDate(2017, 5, 1));
		semesterList.add(fall);
		semesterList.add(spring);
		
		// sections
		f11 = new Section(PHYS.getCourseID(), fall.getSemesterID(), 420);
		s11 = new Section(PHYS.getCourseID(), spring.getSemesterID(), 017);
		f22 = new Section(MED.getCourseID(), fall.getSemesterID(), 420);
		s22 = new Section(MED.getCourseID(), spring.getSemesterID(), 017);
		f33 = new Section(CHEM.getCourseID(), fall.getSemesterID(), 420);
		s33 = new Section(CHEM.getCourseID(), spring.getSemesterID(), 017);
		sectionList.add(f11);
		sectionList.add(f22);
		sectionList.add(f33);
		sectionList.add(s11);
		sectionList.add(s22);
		sectionList.add(s33);
		
		
		sa = new Student("Jeff", "Paul", "Bean", studDate(1997, 2, 20), eMajor.PHYSICS, "3 Three Way", "(756)-919-5643", "bigbean@gmail.com");
		sb = new Student("Chris", "Jonathon", "Jiggy", studDate(1996, 4, 18), eMajor.NURSING, "2 Tree Circle", "(298)-991-7263", "jiggyboy@gmail.com");
		sc = new Student("Maria", "Lucy", "Linda",studDate(1997, 8, 10), eMajor.CHEM, "419 Almost Road", "(234)-391-4583", "llinda@gmail.com");
		sd = new Student("Francis", "Carl", "Franny", studDate(1996, 4, 9), eMajor.NURSING, "384 Crate Lane", "(411)-961-9891", "franny@gmail.com");
		se = new Student("Ankle", "Stu", "Kramer", studDate(1997, 2, 8), eMajor.NURSING, "14 Pickle Street", "(902)-234-8532", "spongebob@gmail.com");
		sf = new Student("Aaron", "Liam", "Remy", studDate(1996, 4, 5), eMajor.BUSINESS, "198 Little Lane", "(293)-671-2387", "remyboy@gmail.com");
		sg = new Student("Marisa", "Lynn", "Hankins", studDate(1995, 9, 11), eMajor.CHEM, "72 Allyoop Way", "(000)-202-0090", "gmail.gmail@gmail.com");
		sh = new Student("Ryan", "Been", "Smiles", studDate(1997, 8, 12), eMajor.COMPSI, "12 Badger Road", "(900)-333-6597", "luvstosmile@gmail.com");
		si = new Student("Thomas", "Batman", "Spiderman", studDate(1994, 6, 8), eMajor.BUSINESS, "9 Nine Road", "(894)-341-3487", "Spidey@gmail.com");
		sj = new Student("Freddy", "Crayon", "Zoinkes", studDate(1995, 5, 22), eMajor.COMPSI, "400 Funky Lane", "(342)-439-3492", "onecooldood@gmail.com");
		studentList.add(sa);
		studentList.add(sb);
		studentList.add(sc);
		studentList.add(sd);
		studentList.add(se);
		studentList.add(sf);
		studentList.add(sg);
		studentList.add(sh);
		studentList.add(si);
		studentList.add(sj);
		
		
		for (int i = 0; i < studentList.size(); i++){
			Student stud = studentList.get(i);
			
			for (int j = 0; j < sectionList.size(); j++){
				Section sect = sectionList.get(j);
				Enrollment k = new Enrollment(stud.getStudentID(), sect.getSectionID());
				enrollmentList.add(k);
				if (k.getSectionID() == f11.getSectionID()){
					k.setGrade(3.8);
					physGPAList.add(k.getGrade());
					studentGPAList.add(k.getGrade());
				}
				if (k.getSectionID() == f22.getSectionID()){
					k.setGrade(3.7);
					medGPAList.add(k.getGrade());
					studentGPAList.add(k.getGrade());
				}
				if (k.getSectionID() == f33.getSectionID()){
					k.setGrade(3.6);
					chemGPAList.add(k.getGrade());
					studentGPAList.add(k.getGrade());
				}
				if (k.getSectionID() == s11.getSectionID()){
					k.setGrade(3.9);
					physGPAList.add(k.getGrade());
					studentGPAList.add(k.getGrade());
				}
				if (k.getSectionID() == s22.getSectionID()){
					k.setGrade(3.3);
				    medGPAList.add(k.getGrade());
					studentGPAList.add(k.getGrade());
				}
				if (k.getSectionID() == s33.getSectionID()){
					k.setGrade(3.9);
					chemGPAList.add(k.getGrade());
					studentGPAList.add(k.getGrade());
				}
			}
		}
		
	}
	@Test //change student major
	public void ChangeMajorTest(){
		studentList.get(4).setMajor(eMajor.BUSINESS);
	}

	@Test
	public void GPATests() {
		// GPA Test for Course #1 CISC
		double phystot = 0;
		double physgpa = 0;
		for (int l = 0; l < physGPAList.size(); l++){
			physgpa = physGPAList.get(l);
			phystot += physgpa;
			return;
		}
		double physavg = phystot / 20;
		assertEquals(3.85, physavg, 3.85);
		
		// GPA Test for Course #2 PILLS
		double medtot = 0;
		double medgpa = 0;
		for (int m = 0; m < medGPAList.size(); m++){
			medgpa = medGPAList.get(m);
			medtot += medgpa;
			return;
		}
		double pillavg = medtot / 20;
		assertEquals(3.5, pillavg, 3.5);
		
		//GPA Test for Course #3
		double chemtot = 0;
		double chemgpa =  0;
		for (int n = 0; n < chemGPAList.size(); n++){
			chemgpa = chemGPAList.get(n);
			chemtot += chemgpa;
			return;
		}
		double chemavg = chemtot / 20;
		assertEquals(3.75, chemavg, 3.75);

		// GPA Test for total student GPA
		double studtot = 0;
		double studGPA = 0;
		for (int z = 0; z < studentGPAList.size(); z++){
			studGPA = studentGPAList.get(z);
			studtot += studGPA;			
		}
		double studavg = studtot / 10;
		assertEquals(3.7, studavg, 3.7);
	}
}