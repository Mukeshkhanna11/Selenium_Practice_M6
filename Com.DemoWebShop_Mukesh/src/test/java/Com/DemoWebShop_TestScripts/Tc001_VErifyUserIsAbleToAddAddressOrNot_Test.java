package Com.DemoWebShop_TestScripts;

import java.io.IOException
;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.AddNewAddress_Page;
import Com.DemoWebShop_POM.Address_Page;

public class Tc001_VErifyUserIsAbleToAddAddressOrNot_Test  extends BaseTest{
	
	
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(3000);
		webDriverUtility.javascriptScrollByElement(driver, homePage.getAddressLink());
		homePage.getAddressLink().click();
		
		Thread.sleep(3000);
		Address_Page addressPage= new Address_Page(driver);
		webDriverUtility.javascriptScrollByElement(driver, addressPage.getAddNewButton());
		webDriverUtility.javascriptClickElement(driver, addressPage.getAddNewButton());
		
		
		AddNewAddress_Page addNewAddressPAge = new AddNewAddress_Page(driver);
		addNewAddressPAge.getFirstNameTextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 0));
		addNewAddressPAge.getLastNameTextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 1));
		addNewAddressPAge.getEmailTextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 2));
		webDriverUtility.selectByVisibleText(addNewAddressPAge.getConuntryDropDown(), fileUtility.readFromExcelFile("Sheet1", 1, 3));
		addNewAddressPAge.getAddressCityTextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 4));
		addNewAddressPAge.getAddress1TextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 5));
		addNewAddressPAge.getPostalCodeTextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 6));
		addNewAddressPAge.getPhoneNumberTextField().sendKeys(fileUtility.readFromExcelFile("Sheet1", 1, 7));
		addNewAddressPAge.getSaveButton().click();
		
		Thread.sleep(3000);
		webDriverUtility.webPageScreenShot(driver);
		
		
		
		
		
		
		
		
		
	}

}
