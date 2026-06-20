package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public Home_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath ="//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	
	@FindBy(partialLinkText = "Addresses")
	private WebElement addressLink;


	public WebElement getLogoutLink() {
		return logoutLink;
	}


	public WebElement getAddressLink() {
		return addressLink;
	}
	
	
	
	

}
