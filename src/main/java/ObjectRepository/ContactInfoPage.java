package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	///rule 2: declaration
	@FindBy(className="dvHeaderText")
	private WebElement ContactHeader;
	
	//rule 3: initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//rule 4: utilization
	public WebElement getContactHeader() {
		return ContactHeader;
	}
	
	//Business library
	/**
	 * This method will return contact header text
	 * @param driver
	 * @return
	 */
	public String getContactHeaderText(WebDriver driver) {
		return ContactHeader.getText();
	}

	

}
