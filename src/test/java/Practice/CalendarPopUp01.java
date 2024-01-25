package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.SeleniumUtility;

public class CalendarPopUp01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new EdgeDriver();
		SeleniumUtility s = new SeleniumUtility();
		s.addImplicitlyWait(driver);
		s.maximizeWindow(driver);
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveByOffset(20, 20).click().perform();
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label=\"Thu Feb 01 2024\"]")).click();
		
		
		Thread.sleep(2000);
		driver.close();
		
		

	}

}
