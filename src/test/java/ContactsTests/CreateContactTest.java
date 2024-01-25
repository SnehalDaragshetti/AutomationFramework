package ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;

@Listeners(GenericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups="RegressionSuite")
	public void CreateContactWithMandatoryInfo() throws IOException, InterruptedException
	{
		//Create objects of utility classes		
		//Read data
		String LastName = eUtil.readFromExcelFile("Contacts", 1, 2); 
		
		//step 1:Launch Browser -- handled by base class
		//step 2: Load URl -- handled by base class
		//step 3: Login to application -- handled by base class
		
		//step 4: Click on contacts link
		HomePage hm = new HomePage(driver);
		hm.clickOnContactsLink();

		
		//step 5:Click on create new contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnCreateContactImage(driver);
		
		//step 6: Create contact with mandatory details and save
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.CreateNewContact(LastName);
		
		//step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader = cip.getContactHeaderText(driver);
		Assert.assertTrue(conHeader.contains(LastName));
		
		//step 8: Logout of application  -- handled by base class
		//step 9: close browser  -- handled by base class
		
		

	}
	@Test
	public void DemoTest() {
		Assert.fail();
		System.out.println("Hi");
	}

}
