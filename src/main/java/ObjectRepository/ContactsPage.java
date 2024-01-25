package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//rule 2: Declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateNewContactImage;
	
	//rule 3: Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//rule 4: Utilization (getters)
	public WebElement getCreateNewContactImage() {
		return CreateNewContactImage;
	}

	
	//Business Library
	public void ClickOnCreateContactImage(WebDriver driver) {
		CreateNewContactImage.click();
	}
	
	
	
	

}
