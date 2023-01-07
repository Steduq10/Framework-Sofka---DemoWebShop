package co.com.client.webproject.test.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @CacheLookup
    @FindBy(className = "ico-register")
    WebElement register;

    @CacheLookup
    @FindBy(className = "ico-login")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick=\"AjaxCart.addproducttocart_catalog('/addproducttocart/catalog/2/1/1    ');return false;\"]")
    WebElement giftCard;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick=\"AjaxCart.addproducttocart_catalog('/addproducttocart/catalog/31/1/1    ');return false;\"]")
    WebElement laptop;

    public WebElement getRegister(){
        return register;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getGiftCard() {
        return giftCard;
    }

    public WebElement getLaptop() {
        return laptop;
    }

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
