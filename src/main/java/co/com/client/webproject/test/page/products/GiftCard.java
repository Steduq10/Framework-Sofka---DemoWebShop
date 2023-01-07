package co.com.client.webproject.test.page.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCard {

    @CacheLookup
    @FindBy(id = "giftcard_2_RecipientName")
    WebElement name;

    @CacheLookup
    @FindBy(id = "giftcard_2_RecipientEmail")
    WebElement email;

    @CacheLookup
    @FindBy(id = "giftcard_2_Message")
    WebElement message;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-2")
    WebElement addToCar;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/']")
    WebElement landingPage;


    public WebElement getName() {
        return name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getAddToCar() {
        return addToCar;
    }

    public WebElement getLandingPage() {
        return landingPage;
    }

    public GiftCard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
