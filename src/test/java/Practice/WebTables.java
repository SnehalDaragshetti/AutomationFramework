package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class WebTables {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		SeleniumUtility s = new SeleniumUtility();
		PropertyFileUtilities p = new PropertyFileUtilities();

		String URL = p.readFromPropertyFile("url");
		String UserName = p.readFromPropertyFile("username");
		String PassWord = p.readFromPropertyFile("password");
		
		WebDriver driver = new EdgeDriver();
		s.addImplicitlyWait(driver);
		s.maximizeWindow(driver);
		
		driver.get("http://localhost:8888/");		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(UserName, PassWord);
		
		HomePage hm = new HomePage(driver);
		hm.clickOnContactsLink();
		
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[6]/td[1]/input")).click();
		
		Thread.sleep(2000);
		driver.close();

	}

}
