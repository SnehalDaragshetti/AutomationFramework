package ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtility;

public class CreateContactWithFirstNameTest {

	public static void main(String[] args) throws IOException {
		//Create Objects of Generic utilities, only those required
		ExcelFileUtilities e = new ExcelFileUtilities();
		PropertyFileUtilities p = new PropertyFileUtilities();
		SeleniumUtility s = new SeleniumUtility();
		
		//Read Data from Files
		String URL = p.readFromPropertyFile("url");
		String USERNAME = p.readFromPropertyFile("username");
		String PASSWORD = p.readFromPropertyFile("password");
		String LASTNAME = e.readFromExcelFile("Contacts", 7, 2);
		String FIRSTNAMETITLE = e.readFromExcelFile("Contacts", 7, 3);
		String FIRSTNAME = e.readFromExcelFile("Contacts", 7, 4);

		//step 1: Launch Browser
		WebDriver driver = new EdgeDriver();
		
		//
		

	}

}
