package FrameworkPractice;

import java.io.IOException;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtilities;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException {	
		
		//PropertyFileUtilities
		PropertyFileUtilities p = new PropertyFileUtilities();
		String value = p.readFromPropertyFile("url");
		System.out.println(value);
		String value1 = p.readFromPropertyFile("username");
		System.out.println(value1);
		String password = p.readFromPropertyFile("password");
		System.out.println(password);
		
		//ExcelFileUtility
		ExcelFileUtilities e = new ExcelFileUtilities();
		String value4= e.readFromExcelFile("Contacts", 1, 1);
		System.out.println(value4);
		
		//Java Utility
		JavaUtility j = new JavaUtility();
		String date = j.getSystemDate();
		System.out.println(date);
		
		
//		int sum = add(10,20);
//		System.out.println(sum);
	}
//	public static int add(int a, int b){
//		int c = a+b;
//		return c;
//	}
}