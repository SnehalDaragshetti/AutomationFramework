package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.SeleniumUtility;

public class CalendarPopUp02 {

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
		Thread.sleep(2000);
		
		String Month="";
		String TargetMonth="July 2024";
		
		for (int i = 0; i < 10; i++) {
			if(Month.equals(TargetMonth)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();		
				Month = driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]")).getText();			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label=\"Thu Jul 04 2024\"]")).click();
		

		
		
		Thread.sleep(2000);
		driver.close();

	}
//	while(Month.equals(TargetMonth)) {
//	driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();		
//	Month = driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]")).getText();
//	System.out.println(Month);
//	Thread.sleep(2000);
//}

}
