package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver dr) {
		
		PageFactory.initElements(dr, this);
	}
}
