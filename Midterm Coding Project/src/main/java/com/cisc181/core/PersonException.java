package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonException extends Exception{
	
	
	public Date DOB;
	public String phone;
	public Person person;
	
	public String getPerson(String Person){
		return Person;
	}
	
	public Date getDOB(){
		return DOB;
	}
	public PersonException(Person person){
		this.person = person;
	}
	
	public PersonException(PersonException personException){
		
	}
	
	
	public void setDOB(Date DOB) throws PersonException{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 100);
		if (calendar.getTime().before(DOB)){
			throw new PersonException(this);
		}
		this.DOB = DOB;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String newphone) throws PersonException {
		Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
		if (!pattern.matcher(newphone).matches()){
			throw new PersonException(this);
		}
		phone = newphone;
	}

}