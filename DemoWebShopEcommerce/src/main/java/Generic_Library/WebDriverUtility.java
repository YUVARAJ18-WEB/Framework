package Generic_Library;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * This method created for all reusable methods
 * 
 * @author User
 */
public class WebDriverUtility implements FrameworkConstants {

	public static Actions action;
	public static JavascriptExecutor je;
	
	
	
	// select options by using index
	public static void selectOptionsByIndex(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	// select options by using Value
	public static void selectOptionsByValue(WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

	// select options by using Visible text
	public static void selectOptionsByVisibleText(WebElement dropdown, String text) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}

	/**
	 * This method is created for switching one window to another window by using
	 * URL and Title
	 * 
	 * @param dr
	 * @param url
	 */

	// switch to window by using URL
	public static void switchToWindowByURL(WebDriver dr, String url) {

		Set<String> allWindows = dr.getWindowHandles();
		for (String window : allWindows) {
			dr.switchTo().window(window);
			if (dr.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	// switch to window by using Title
	public static void switchToWindowByTitle(WebDriver dr, String title) {

		Set<String> allWindows = dr.getWindowHandles();
		for (String window : allWindows) {
			dr.switchTo().window(window);
			if (dr.getTitle().contains(title)) {
				break;
			}
		}
	}

	/**
	 * This method is created for switching one frame to another frame by using
	 * Index , NameOrId , WebElement
	 */

	// switch to frame by using index
	public static void switchToFrameByIndex(WebDriver dr, int index) {

		dr.switchTo().frame(index);
	}

	// switch to frame by using nameOrID
	public static void switchToFrameByNameOrID(WebDriver dr, String nameOrId) {

		dr.switchTo().frame(nameOrId);
	}

	// switch to frame by using webElement
	public static void switchToFrameByWebElement(WebDriver dr, WebElement frameElement) {

		dr.switchTo().frame(frameElement);
	}

	/**
	 * This method is created for all webDriver methods
	 */

	// all webDriver methods
	// click
	public static void clickElement(WebElement element) {

		element.click();
	}

	// Send keys
	public static void enterText(WebElement element, String text) {

		element.sendKeys(text);
	}

	/**
	 * This method is created for to take screenshot of webPage
	 */

	public static void getScreenshotOfWebPage(WebDriver dr) {

		TakesScreenshot ts = (TakesScreenshot) dr;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(SCREENSHOT_PATH + getSystemDate() + ".png");

		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is created for to take screenshot of webElement
	 */

	public static void getScreenshotOfWebElement(WebElement element) {

		File temp = element.getScreenshotAs(OutputType.FILE);
		File perm = new File(SCREENSHOT_PATH + getSystemDate() + ".png");

		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// methods to handle alert
	public static void switchToAlertAndAccept(WebDriver dr) {

		dr.switchTo().alert().accept();
	}

	public static void switchToAlertAndDismiss(WebDriver dr) {

		dr.switchTo().alert().dismiss();
	}

	public static String switchToAlertAndGetText(WebDriver dr) {

		return dr.switchTo().alert().getText();
	}

	public static void switchToAlertAndSendText(WebDriver dr, String text) {

		dr.switchTo().alert().sendKeys(text);
	}

	// Methods to handle mouse actions
	public static void mouseHover(WebDriver dr, WebElement element) {

		action.moveToElement(element).perform();
	}

	public static void mouseClick(WebDriver dr, WebElement element) {

		action.click(element).perform();
	}

	public static void rightClick(WebDriver dr, WebElement element) {

		action.contextClick(element).perform();
	}

	/**
	 * Method to handle hidden or disabled button
	 * 
	 * @return
	 */

	public static void clickOnHidddenOrDisabledButton(WebDriver dr, WebElement element) {

		je.executeScript("arguments[0].click();", element);
	}

	/**
	 * Method to handle hidden or disabled text field
	 * 
	 * @return
	 */

	public static void clickOnHidddenOrDisabledTextField(WebDriver dr, WebElement element, String value) {

		je.executeScript("arguments[0].value=" + value + ";", element);
	}

	/**
	 * Methods to scroll the window to the given x and y value
	 * 
	 * @return
	 */

	public static void scrollByXAndYValue(WebDriver dr, int x, int y) {

		je.executeScript("window.scrollTo(" + x + "," + y + ");");
	}

	/**
	 * Methods to scroll the window to the given x and y
	 * 
	 * @return
	 */

	public static void scrollToXAndYValue(WebDriver dr, int x, int y) {

		je.executeScript("window.scrollTo(" + x + "," + y + ");");
	}

	/**
	 * Methods to scroll the window to top of the webElement
	 * 
	 * @return
	 */

	public static void scrollIntoView(WebDriver dr, WebElement element, boolean position) {

		je.executeScript("arguments[0].scrollIntoview(" + position + ");", element);
	}

	/**
	 * Methods to initialize the objects like Actions and JavaScriptExecutor
	 * 
	 * @return
	 */

	public static void initObjects(WebDriver dr) {

		action = new Actions(dr);
		je = (JavascriptExecutor) dr;
	}

	// get the system date and time
	public static String getSystemDate() {

		return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	}
}
