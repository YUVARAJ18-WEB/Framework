package Test_Scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Library.BaseClass;
import ObjectRepository.BookPage;
import ObjectRepository.HomePage;

public class BooksTest extends BaseClass {

	@Test
	public void booksTest_001() throws Exception {

		HomePage hp = new HomePage(dr);
		BookPage bp = new BookPage(dr);

		// click on books link
		hp.getBooksLink().click();

		// select by index
		selectOptionsByIndex(bp.getSortByDropdown(), 3);
		Thread.sleep(2000);

		// select by value
		selectOptionsByValue(bp.getSortByDropdown(), "https://demowebshop.tricentis.com/books?orderby=5");
		Thread.sleep(2000);
	}

	@Test
	public void booksTest_002() throws Exception {

		HomePage hp = new HomePage(dr);
		BookPage bp = new BookPage(dr);

		// click on books link
		hp.getBooksLink().click();

		// select by index
		selectOptionsByVisibleText(bp.getPageSizeByDropdown(), "12");
		Thread.sleep(2000);

	}

	@Test
	public void booksTest_003() throws Exception {

		HomePage hp = new HomePage(dr);
		BookPage bp = new BookPage(dr);

		// click on books link
		hp.getBooksLink().click();

		// select by index
		selectOptionsByVisibleText(bp.getViewAsByDropdown(), "List");
		Thread.sleep(2000);

	}
	
	@Test
	
	public void verifyBookPage() {
		
		HomePage hp = new HomePage(dr);
		BookPage bp = new BookPage(dr);
		
		Reporter.log("Verify books page is Displayed",true);
		
		hp.getBooksLink().click();
		
		test.log(LogStatus.INFO, "Clicked on books link");
		
		String pageHeading = bp.getBooksPageHeading().getText();
		
		Assert.assertEquals(pageHeading, "Books","Books is not displayed");
		
		test.log(LogStatus.PASS, "Test case Completed");
		
		String path = getScreenshotOfWebPage(dr);
		
		test.log(LogStatus.FAIL, test.addScreenCapture(path));
		
		Reporter.log("Test case Completed and it is passed", true);
	}
}
