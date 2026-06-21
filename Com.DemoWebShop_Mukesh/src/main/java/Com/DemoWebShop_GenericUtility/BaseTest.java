package Com.DemoWebShop_GenericUtility;

import java.io.IOException
;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.DemoWebShop_POM.Home_Page;
import Com.DemoWebShop_POM.Login_Page;
import Com.DemoWebShop_POM.Welcome_Page;

public class BaseTest {

	public WebDriver driver;

	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileUtility = new FileUtility();
	public Home_Page homePage;
	public Login_Page loginPage;
	public Welcome_Page welcomePage;
	
	public WebDriverUtility webDriverUtility = new WebDriverUtility();
	public WebDriverWait wait;
	

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("suite");

		System.out.println("suite --- database connection");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("befor test--- report generation");
		spark = new ExtentSparkReporter(FrameWrokConstants.extentReportPath);

		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Demo");

	}

	@BeforeClass
	public void beforClass() throws IOException {
		System.out.println("before class ---browser setup");

//		String browser = fileUtility.readFromPropertyFile("browserName");
//		String url = fileUtility.readFromPropertyFile("url");
		
		String browser =System.getProperty("browserName");
		String url = System.getProperty("baseUrl");

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("chrome browser");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("chrome browser");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("chrome browser");
			driver = new EdgeDriver();

		} else {
			System.out.println("invalid browser");
		}

		sDriver = driver;
		
   wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {

		System.out.println("before method---login to application");
		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginLink().click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readFromPropertyFile("password"));

		loginPage.getLoginButton().click();
		Thread.sleep(3000);
		homePage = new Home_Page(driver);

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("after method ---logout of application");
		Thread.sleep(1000);
		homePage.getLogoutLink().click();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("after class --- browser close");

		Thread.sleep(2000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test---report closed");
		reports.flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite ---database disconnected");
	}

}
