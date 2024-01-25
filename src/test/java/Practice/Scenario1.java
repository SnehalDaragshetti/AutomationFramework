package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//step 1: Launch browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//step 2: Load the URL
		driver.get("http://localhost:8888/");
		
		//step 3: Login to app with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 4: Navigate to Contacts link
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		
		//step 5: Click on Create Contact look up image
		//driver.findElement(By.linkText("Create Contact...")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		//step 6: Create Contact with Mandatory information
		driver.findElement(By.name("lastname")).sendKeys("IronMan");
		
		//step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 8: Verify for contact -- Validate
		String conHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if(conHeader.contains("IronMan")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//step 9: Logout of App
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		act.moveToElement(ele).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		//step 10: Close the browser
		driver.close();


	}

}
