package Test_Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Library.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.JewelryPage;

public class JewelryTest extends BaseClass {
	
	@Test
	public void DiamondHeartTest() {
		
		HomePage hp = new HomePage(dr);
		JewelryPage jp = new JewelryPage(dr);
		
		//Take Screenshot of webPage
		getScreenshotOfWebPage(dr);
		
		//click on jewelry link
		hp.getJewelryLink().click();
		
		//Take Screenshot of webElement
		getScreenshotOfWebElement(jp.getBlackAndWhiteDiamondHeartImage());
		
		String str="ScreenShot Taken";
		
		Reporter.log(str,true);
	}
}
