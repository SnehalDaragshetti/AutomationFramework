package ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateContactWithLeadSourceTest extends BaseClass{

	@Test(groups="RegressionSuite")
	public void CreateContactWithLead()throws EncryptedDocumentException, IOException, InterruptedException {
			
				
		//step 4: Click on contacts link
		HomePage hm = new HomePage(driver);
		hm.clickOnContactsLink();
				
		//step 5:Click on create new contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnCreateContactImage(driver);
			
		//step 6: Create contact with mandatory details and save
		String LEADSOURCE = eUtil.readFromExcelFile("Contacts", 4, 3);
		String LASTNAME = eUtil.readFromExcelFile("Contacts", 1, 2);
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.CreateNewContact(LASTNAME, LEADSOURCE);
		
		//step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader = cip.getContactHeaderText(driver);
		if(conHeader.contains(LASTNAME)) {
			System.out.println("Test case PASSED");
			System.out.println(conHeader);
		}else {
			System.out.println("Test case FAILED");
		}
	}

}
