package Com.DemoWebShop_GenericUtility;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	
	
	public void webPageScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(FrameWrokConstants.screenshotPath);
		FileHandler.copy(temp, dest);
		
	}
	
	public void webElementScreenShot(WebElement element) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWrokConstants.screenshotPath);
		FileHandler.copy(temp, dest);
	}
	
	public void selectByVisibleText(WebElement getAddressValue,String value) {
		
		Select sel = new Select(getAddressValue);
		sel.selectByVisibleText(value);
		
	}
	
	
	public void  javascriptScrollByElement(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}
	
	public void javascriptClickElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		
	}
	public void switchToAllertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	
	
	
	
	
	
	
}



