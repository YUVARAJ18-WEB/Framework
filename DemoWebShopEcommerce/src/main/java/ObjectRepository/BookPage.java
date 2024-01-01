package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BasePage {

	public BookPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "products-orderby")
	private WebElement sortByDropdown;
	
	@FindBy(id = "products-pagesize")
	private WebElement pageSizeByDropdown;
	
	@FindBy(id = "products-viewmode")
	private WebElement viewAsByDropdown;
	
	@FindBy(xpath = "//div[@class='page-title']//h1[.='Books']")
	private WebElement booksPageHeading;

	public WebElement getBooksPageHeading() {
		return booksPageHeading;
	}

	public WebElement getSortByDropdown() {
		return sortByDropdown;
	}

	public WebElement getPageSizeByDropdown() {
		return pageSizeByDropdown;
	}

	public WebElement getViewAsByDropdown() {
		return viewAsByDropdown;
	}
	
}
