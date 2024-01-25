package FrameworkPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class Scenario1WithDDTandGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Create object of all Utility Classes
		ExcelFileUtilities e = new ExcelFileUtilities();
		PropertyFileUtilities p = new PropertyFileUtilities();
		SeleniumUtility s = new SeleniumUtility();
		
		//Read all data
		/*Read data from property file*/
		String URL = p.readFromPropertyFile("url");
		String UserName = p.readFromPropertyFile("username");
		String PassWord = p.readFromPropertyFile("password");
		
		/*Read data from excel file*/
		String LastName = e.readFromExcelFile("Contacts",1,2);
		
		//step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		s.maximizeWindow(driver);
		s.addImplicitlyWait(driver);
		
		//step 2: Load URL
		driver.get(URL);
		
		ContactsPage cp = new ContactsPage(driver);
		CreateContactPage cc = new CreateContactPage(driver);

		
		//step 3: login to application
//		driver.findElement(By.name("user_name")).sendKeys(UserName);
//		driver.findElement(By.name("user_password")).sendKeys(PassWord);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(UserName, PassWord);
		
//		lp.getUserNameEdt().sendKeys(UserName);
//		lp.getPasswordEdt().sendKeys(PassWord);
//		lp.getLoginBtn().click();
		
		//step 4: Navigate to contacts link
//		driver.findElement(By.linkText("Contacts")).click();
		HomePage h = new HomePage(driver);
		h.clickOnContactsLink();
		
		//step 5: Click on create contact lookup image
//		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		cp.ClickOnCreateContactImage(driver);
		cc.CreateNewContact(LastName);		
		
		//step 6: create contact with mandatory details
//		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		//step 7: save
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//		cp.ClickOnSaveBtn(driver);
		
		//step 8: validate
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (conHeader.contains(LastName)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		//step 9: Log out
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		s.mouseHoverAction(driver, ele);
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Sign Out")).click();
//		HomePage hp = new HomePage(driver);
		h.LogOutOfApp(driver);
		
		//step 10: close browser
		driver.close();
		
		

	}

}