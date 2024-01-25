package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class CreateContactPage extends SeleniumUtility {
	//rule 2: Declaration
	@FindBy(name="lastname")
	private WebElement LastNameTextField;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	@FindBy(name="leadsource")
	private WebElement LeadSourceDropDown;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstNameTextField;
	
	@FindBy(name="salutationtype")
	private WebElement FirstNameSalutation;
	
	
	//rule3: Initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//rule 4: Utilization (getters)
	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement LeadSourceDropDown() {
		return LeadSourceDropDown;
	}
	
	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getFirstNameSalutation() {
		return FirstNameSalutation;
	}
	
	//Business Library
	/**
	 * This method will click on save button in create contact page
	 * @param driver
	 */
	public void ClickOnSaveBtn(WebDriver driver) {
		SaveBtn.click();
	}
	
	/**
	 * This method will create contact with mandatory details: Last name
	 * @param LastName
	 */
	public void CreateNewContact(String LastName) {
		LastNameTextField.sendKeys(LastName);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact with last name and lead source drop down
	 * @param LastName
	 * @param LeadSourceValue
	 */
	public void CreateNewContact(String LastName, String LeadSourceValue ) {
		LastNameTextField.sendKeys(LastName);
		handleDropdown(LeadSourceDropDown, LeadSourceValue);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact with last name, first name title and first name
	 * @param LastName
	 * @param FirstNameTitle
	 * @param FirstName
	 */
	public void CreateNewContact(String LastName, String FirstNameTitle, String FirstName) {
		LastNameTextField.sendKeys(LastName);
		handleDropdown(FirstNameSalutation, FirstNameTitle);
		FirstNameTextField.sendKeys(FirstName);
		SaveBtn.click();

	}
	
	

}
