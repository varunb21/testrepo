package com.globalMethods.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MayankM
 *
 */

public class DataGeneratorEmployee {

	public static String[] stateList = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
			"IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
			"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WI", "WV", "WY" };

	public static String[] gender = { "M", "F", "O"};

	public static String EmpPosition[]= {"HHA","HCA","RN","LPN","PCA"};

	//Max length : Alphanumeric : 15
	public static String generateEmpPrimaryLoc(int i)
	{
		String emploc = CommonMethods.generateRandomStringOfFixLength(i);
		return emploc;
	}

	//Max length : Alphanumeric : 50
	public static String generateEmpEmail(int i)
	{
		String domain="@mailinator.com";
		String empemail = CommonMethods.generateRandomAlphaNumeric(i);
		return empemail.concat(domain);
	}

	//Min length : numeric : 4 | Max length : numeric : 9  
	public static String generateEmpPIN(int i) 
	{
		String emppin = CommonMethods.generateRandomNumberOfFixLength(i);
		return emppin;
	}

	//Max length : Alphanumeric : 3 
	public static String generateEmpDept(int i)
	{
		String empdept = CommonMethods.generateRandomAlphaNumeric(i);
		return empdept;
	}

	public static String generateEmpHireDate()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String emphiredate = dateFormat.format(date);
		return emphiredate;
	}

	// Max Length : String : 2
	public static String generateEmpState() {
		String empstate = stateList[CommonMethods.getRandomInt(0, (stateList.length) - 1)];
		return empstate;
	}

	public static String generateEmpBirthDate()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String emphiredate = dateFormat.format(date);
		return emphiredate;
	}

	public static String generateEmpEndDate()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String emphiredate = dateFormat.format(date);
		return emphiredate;
	}

	public static String generateEmpIDCustom(int i)
	{
		String empidcustom = CommonMethods.generateRandomAlphaNumeric(i);
		return empidcustom;
	}

	public static String generateEmpDiscipline(int i)
	{
		String empdisc = CommonMethods.generateRandomStringOfFixLength(i);
		return empdisc;
	}

	//these excepted values [\u0027EmployeeSSN|EmployeeRegID|EmployeeCustomID\
	public static String EmployeeQualifiertype(String addtype) {
		return addtype;
		
	}
	
	public static String generateStaffPosition() {
		String SPos = EmpPosition[CommonMethods.getRandomInt(0, (EmpPosition.length) - 1)];
		return SPos;
	}
}
