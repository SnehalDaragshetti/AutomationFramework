package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	//rule 2: Declaration
	@FindBy(linkText ="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdminImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	//rule 3: Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//rule 4: Declaration
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getAdminImage() {
		return AdminImage;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	//Business Library
	public void clickOnContactsLink() {
		ContactsLink.click();
	}
	
	//Business Library
	public void LogOutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, AdminImage);
		Thread.sleep(1000);
		SignOutLink.click();
	}
	
	
	

}
