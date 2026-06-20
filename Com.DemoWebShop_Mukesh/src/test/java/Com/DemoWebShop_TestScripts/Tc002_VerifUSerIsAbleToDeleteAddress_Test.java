package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Address_Page;

public class Tc002_VerifUSerIsAbleToDeleteAddress_Test  extends BaseTest{
	
	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		webDriverUtility.javascriptScrollByElement(driver, homePage.getAddressLink());
		homePage.getAddressLink().click();
		
		Address_Page addAddressPage = new Address_Page(driver);
		addAddressPage.getDeleteButton().click();
		wait.until(ExpectedConditions.alertIsPresent());
		webDriverUtility.switchToAllertAccept(driver);
		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);
		
		
		
	}

}
