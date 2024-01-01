package Test_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	ExtentReports report = new ExtentReports("./Reports/report.html");
	ExtentTest test = report.startTest("loginTest");
	
	@Test 
	public void reportTest() {
		
		WebDriver dr = new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome Opened");
		
		dr.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome Maximized");
		
		dr.get("https://demowebshop.tricentis.com/");
		
		dr.findElement(By.partialLinkText("Log in")).click();
		
		dr.findElement(By.id("Email")).sendKeys("gilchrist@gmail.com");
		
		dr.findElement(By.id("password")).sendKeys("Yuvi@18");
		
		dr.findElement(By.cssSelector("[value='Log in']")).click();
		
		Assert.assertEquals(dr.findElement(By.linkText("Log out")).isDisplayed(), true,"Log out is not displayed");
		
		test.log(LogStatus.PASS, "Login Successful");
		
		report.endTest(test);
		
		dr.quit();
	}
	
	@Test 
	public void reportTest2() {
		
		WebDriver dr = new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome Opened");
		
		dr.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome Maximized");
		
		dr.get("https://demowebshop.tricentis.com/");
		
		dr.findElement(By.partialLinkText("Log in")).click();
		
		dr.findElement(By.id("Email")).sendKeys("gilchrist@gmail.com");
		
		dr.findElement(By.id("password")).sendKeys("Yuvi@18");
		
		dr.findElement(By.cssSelector("[value='Log in']")).click();
		
		Assert.assertEquals(dr.findElement(By.linkText("Log out")).isDisplayed(), true,"Log out is not displayed");
		
		test.log(LogStatus.FAIL, "Log in Successful");
		
		report.endTest(test);
		
		dr.quit();
	}
	
}
