package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class Scenario1WithObjectRepo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// create object
		//1. Utility class
		ExcelFileUtilities e = new ExcelFileUtilities();
		PropertyFileUtilities p = new PropertyFileUtilities();
		SeleniumUtility s = new SeleniumUtility();
		
		//Read all data
		// Excel file
		String LASTNAME = e.readFromExcelFile("Contacts", 4, 2);
		
		//properties file
		String URL = p.readFromPropertyFile("url");
		String USERNAME = p.readFromPropertyFile("username");
		String PASSWORD = p.readFromPropertyFile("password");
				
		//step 1: launch browser 
		WebDriver driver = new EdgeDriver();
		s.addImplicitlyWait(driver);
		s.maximizeWindow(driver);
		
		//Create Object 2. ObjectRepository - not a good approach ma'am says: create them only when needed
		HomePage hm = new HomePage(driver); //57 create it there 
		ContactsPage cp = new ContactsPage(driver);
		LoginPage lp = new LoginPage(driver); //54 line create it
		CreateContactPage cc = new CreateContactPage(driver);
		ContactInfoPage cip = new ContactInfoPage(driver);

		
		//step 2: load url
		driver.get(URL);
		
		//step 3: login
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step 4: Click on contacts page
		hm.clickOnContactsLink();
		
		//step 5: Click on create contact lookup image
		cp.ClickOnCreateContactImage(driver);
		
		//step 6: create contact with mandatory details
		//step 7: save
		cc.CreateNewContact(LASTNAME);
		
		//step 8: validate
		String conHeader = cip.getContactHeaderText(driver); 
		if (conHeader.contains(LASTNAME)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
				
		//step 9: Log out
		hm.LogOutOfApp(driver);
				
		//step 10: close browser
		driver.close();

	}

}
