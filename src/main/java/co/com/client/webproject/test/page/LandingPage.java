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

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div[3]/ul/li[4]/a")
    WebElement shoppingCar;

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

    public WebElement getShoppingCar() {
        return shoppingCar;
    }

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
