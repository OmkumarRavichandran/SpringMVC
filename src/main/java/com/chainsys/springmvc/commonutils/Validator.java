package com.chainsys.springmvc.commonutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean checkStringForParse(String data) throws InvalidInputDataException {
		// TODO--This method is incomplete
		boolean result = false;
		int len = data.length();
		for (int index = 0; index < len; index++) {
			int asc = (int) data.charAt(index);
			if (asc > 47 && asc < 58)
				result = true;
			else
				throw new InvalidInputDataException("enter numeric value only");
		}
		return result;
	}

	 public static void checkDate(String emp_HireDate) {
			
		    if (emp_HireDate.matches("[0-9]{2}[.]{1}[0-9]{2}[.]{1}[0-9]{4}")) {
		      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		      sdf.setLenient(false);
		      try {
		        Date d1 = sdf.parse(emp_HireDate);
		        System.out.println("Valid");
		      } catch (ParseException e) {
		        System.out.println("Invalid");
		      }
		    } else if (emp_HireDate.matches("[0-9]{2}[/]{1}[0-9]{2}[/][0-9]{4}")) {
		      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		      sdf.setLenient(false);
		      try {
		        Date d1 = sdf.parse(emp_HireDate);
		        System.out.println("Valid");
		      } catch (ParseException e) {
		        System.out.println("Invalid");
		      }
		    } else if (emp_HireDate.matches("[0-9]{2}[-]{1}[0-9]{2}[-][0-9]{4}")) {
		      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		      sdf.setLenient(false);
		      try {
		        Date d1 = sdf.parse(emp_HireDate);
		        System.out.println("Valid");
		      } catch (ParseException e) {
		        System.out.println("Invalid");
		      }
		    } else
		    	throw new InvalidInputDataException("enter valid Date ");
		    
		  }
	 

	public static boolean CheckNumberForGreaterThanZero(int data) throws InvalidInputDataException {
		boolean result = false;
		if (data > 0) {
			result = true;
		} else
			throw new InvalidInputDataException();
		return result;
	}
	public static void CheckNumberForGreaterThanZero(float data) throws InvalidInputDataException {
		if (data < 0)
			throw new InvalidInputDataException("please enter value greater than zero");

	}

	public static boolean checklengthOfString(String data) throws InvalidInputDataException {
		boolean result = false;
		int len = data.length();
		if (len < 3)
			throw new InvalidInputDataException("length Does not meet required length ");
		else if (len > 15)
			throw new InvalidInputDataException("length exceeds the required length");
		else
			result = true;
		return result;
	}

	public static boolean checkStringOnly(String data) throws InvalidInputDataException {
		boolean result = false;
		int len = data.length();
		for (int index = 0; index < len; index++) {
			data.toUpperCase();
			int asc = (int) data.charAt(index);
			if (asc > 64 && asc < 91) {
				result = true;
			} else if (asc > 96 && asc < 123) {
				result = true;
			} else
				throw new InvalidInputDataException("Enter Alphabets Only");
		}
		return result;
	}

	public static boolean checkMail(String email) throws InvalidInputDataException {
		boolean result = false;
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if (email == null)
			throw new InvalidInputDataException("enter email id ");
		else if (Pattern.compile(regexPattern).matcher(email).matches()) {
			result = true;
		} else {
			throw new InvalidInputDataException("enter valid email id ");
		}
		return result;
	}



	public static boolean checkjob(String data) throws InvalidInputDataException {
		boolean result = false;
		int len = data.length();
		for (int index = 0; index < len; index++) {
			data.toUpperCase();
			int asc = (int) data.charAt(index);
			if ((asc < 65) || (asc > 90)) {
				if (asc == 95)
					result = true;
				else
					throw new InvalidInputDataException("Enter Alphabets(A-Z) and underscore(_) only");
			} else
				return true;
		}
		return result;
	}

	public static boolean checkSalLimit(float salParse) throws InvalidInputDataException {
		boolean result = false;

		if (salParse < 0 && salParse > 1000000) {
			System.out.println("Enter amount between 0 to 1 Lac");
		} else if (salParse % 500 != 0) {
			System.out.println("Enter amount in multiples of five hundred");
		} else {
			result = true;
		}
		return result;
	}

	public static void checkPhone(String data) throws InvalidInputDataException {
		boolean result = false;
		String pattern = "^[0-9]{10}$";
		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result = match.matches();
		if (!result)
			throw new InvalidInputDataException("please enter 10 digit ");
	}
	
	public static boolean CheckNumberForGreaterThanZero(long data) throws InvalidInputDataException {
		boolean result = false;
		if (data > 0) {
			result = true;
		} else
			throw new InvalidInputDataException();
		return result;
	}
}
