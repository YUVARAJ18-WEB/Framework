package Generic_Library;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass extends WebDriverUtility{

	public WebDriver dr;
	
	@BeforeSuite
	public void beforeSuite() {
		
		report=new ExtentReports(REPORT_PATH);
		
		Reporter.log("Connect to Database", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		
		report.flush();
		
		Reporter.log("Close Connection to Database", true);
	}
	
	@BeforeTest
	public void beforetest() {
		
		Reporter.log("Before Test", true);
	}
	
	@AfterTest
	public void aftertest() {
		
		Reporter.log("After Test", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		
		Reporter.log("Before Class", true);
		String browser = FileUtility.getProperty("browser");
		String url = FileUtility.getProperty("url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			dr=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			dr=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			dr=new FirefoxDriver();
		}
		else {
			dr=new ChromeDriver();
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.get(url);
		
	}
	
	@AfterClass
	public void afterClass() {
		
		Reporter.log("After Class", true);
		dr.quit();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		
		Reporter.log("Log in", true);
		
		String methhodName=method.getName();
		
		test=report.startTest(methhodName);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
		Reporter.log("Log out", true);
	
		report.endTest(test);
	
	}
}
