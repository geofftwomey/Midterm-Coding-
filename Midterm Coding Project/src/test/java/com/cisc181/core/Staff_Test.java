package com.cisc181.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.*;
import java.util.Date;

public class Staff_Test {
	static ArrayList<Staff> stafflist = new ArrayList<Staff>();
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setup() throws Exception {
		
		stafflist.add(new Staff("Joe","Stinky","Smith", new Date(1974, 5, 25), "37 Main St", "(508)-277-8372", "stinkysmith@gmail.com", "Wednesday & Thursday 5:30 PM - 7:30 PM ", 1, 420000, new Date(2011, 2, 14), com.cisc181.eNums.eTitle.MR));
		stafflist.add(new Staff("John", "Brandon", "Philips", new Date(1950, 5, 11), "67 Newbury St","(555)-843-7462","jphilips@gmail.com","Monday 1 PM - 4 PM", 2, 400000, new Date(2007, 5, 12),com.cisc181.eNums.eTitle.MR));
		stafflist.add(new Staff("Chris", "William", "Tyler", new Date(1970, 1,1), "2 Blanket Way", "(238)-335-9475", "cwt398@yahoo.com","Monday 9 AM - 1 PM", 3, 500000, new Date(2002, 9, 20), com.cisc181.eNums.eTitle.MR));
		stafflist.add(new Staff("Harry", "Evan", "Billing", new Date(1964, 10, 30), "46 Lakeview Terrace", "(734)-928-3624", "dirtyharry@gmail.com", "Friday 11 PM - 11:30 PM", 4, 450000, new Date(1999, 9, 9), com.cisc181.eNums.eTitle.MR));
		stafflist.add(new Staff("Jacob", "Grant", "Peters", new Date(1949, 7, 27), "97 Tree Branch Lane", "(237)-120-2859", "myemail@gmail.com", "Tuesday 3 PM - 5 PM", 5, 1000000, new Date(1987, 10, 10), com.cisc181.eNums.eTitle.MR));
		
	}
	

	@Test
	public void avgSlry() {
		double sum = 0;
		for (Staff i : stafflist){
			sum += i.getSalary();
		}
		double avg = sum / 5;
		assertEquals(554000.0, avg, 1);}
		
	@Test(expected = PersonException.class)
	public void testDOB() throws PersonException{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 120);
		Staff staff = new Staff(eTitle.MR);
		staff.setDOB(calendar.getTime());
	}	
	
	@Test(expected = PersonException.class)
	public void TestPhone() throws PersonException{
		Staff staff = new Staff(eTitle.MR);
		staff.setPhone("(456-7890");
	}

}