package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

/**
 * this class consists of all the base class methods
 * @author Snehal
 */
public class BaseClass {
	
	public ExcelFileUtilities eUtil = new ExcelFileUtilities();
	public PropertyFileUtilities pUtil = new PropertyFileUtilities();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public JavaUtility jUtil = new JavaUtility();
		
	public WebDriver driver;
	
	//for listeners:
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("=======DB COnnection Successful =======");
	}
	
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
//	public void bcConfig(String BROWSER) throws IOException {
	public void bcConfig() throws IOException {

		String URl = pUtil.readFromPropertyFile("url");
		driver = new EdgeDriver();
		
//		if(BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		}else {
//			driver = new ChromeDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URl);
		
		System.out.println("=======Browser Launch Successfull========");
		
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readFromPropertyFile("username");
		String PASSWORD = pUtil.readFromPropertyFile("password"); 
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("======= Login to App Successful =======");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.LogOutOfApp(driver);
		
		System.out.println("======= Logout of App Successful =======");
	}
	
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("======= Browser Closure Successful =======");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("======= DB Closure Successful =======");
	}
	

}
