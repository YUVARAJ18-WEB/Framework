package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Register")
	private WebElement regiasterLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(partialLinkText  = "log out")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText  = "Shopping")
	private WebElement shoppingCartLink;
	
	@FindBy(partialLinkText  = "Wishlist")
	private WebElement wishlistLink;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "JEWELRY")
	private WebElement jewelryLink;
	
	@FindBy(id  = "small-searchterms")
	private WebElement searchTextField;
	
	@FindBy(css = "[value='Search']")
	private WebElement searchButton;

	//Getter Method
	public WebElement getRegiasterLink() {
		return regiasterLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getJewelryLink() {
		return jewelryLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
