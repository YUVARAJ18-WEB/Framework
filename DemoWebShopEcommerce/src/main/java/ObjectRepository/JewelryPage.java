package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JewelryPage extends BasePage{

	public JewelryPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Black & White Diamond Heart")
	private WebElement blackAndWhiteDiamondHeartLink;
	
	@FindBy(css  = "[alt='Picture of Black & White Diamond Heart']")
	private WebElement blackAndWhiteDiamondHeartImage;
	
	@FindBy(xpath  = "//a[.='Black & White Diamond Heart']/../..//span")
	private WebElement blackAndWhiteDiamondHeartPrice;
	
	@FindBy(xpath  = "//a[.='Black & White Diamond Heart']/../..//input")
	private WebElement blackAndWhiteDiamondHeartAddToCartButton;

	public WebElement getBlackAndWhiteDiamondHeartLink() {
		return blackAndWhiteDiamondHeartLink;
	}

	public WebElement getBlackAndWhiteDiamondHeartImage() {
		return blackAndWhiteDiamondHeartImage;
	}

	public WebElement getBlackAndWhiteDiamondHeartPrice() {
		return blackAndWhiteDiamondHeartPrice;
	}

	public WebElement getBlackAndWhiteDiamondHeartAddToCartButton() {
		return blackAndWhiteDiamondHeartAddToCartButton;
	}
	
}
