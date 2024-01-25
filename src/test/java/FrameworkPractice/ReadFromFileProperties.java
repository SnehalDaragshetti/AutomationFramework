package FrameworkPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromFileProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//step 1: Open the document in Java Readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2: create Obj of properties class form java.util
		Properties p = new Properties();
		
		//step 3: load the fis into properties class
		p.load(fis);

		//step 4: Provide key and read the value
		String url = p.getProperty("url");
		System.out.println(url);
		String username = p.getProperty("username");
		System.out.println(username);
		String password = p.getProperty("password");
		System.out.println(password);
		String value = p.getProperty("value");
		System.out.println(value);
	}

}