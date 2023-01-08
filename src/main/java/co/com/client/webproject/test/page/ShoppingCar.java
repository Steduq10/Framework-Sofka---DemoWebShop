package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCar {

    @CacheLookup
    @FindBy(xpath = "//a[@href='/25-virtual-gift-card']")
    WebElement giftCard;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/141-inch-laptop']")
    WebElement laptop;

    @CacheLookup
    @FindBy(id = "CountryId")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//option[@value='22']")
    WebElement countrySelected;

    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement terms;

    @CacheLookup
    @FindBy(id = "checkout")
    WebElement checkout;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='removefromcart'])[1]")
    WebElement removeGiftCard;

    @CacheLookup
    @FindBy(xpath = "(//input[@name='removefromcart'])[2]")
    WebElement removeLaptop;

    @CacheLookup
    @FindBy(xpath = "//input[@name='updatecart']")
    WebElement updateCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='order-summary-content']")
    WebElement emptyCarMessage;




    public WebElement getGiftCard() {
        return giftCard;
    }

    public WebElement getLaptop() {
        return laptop;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getCountrySelected() {
        return countrySelected;
    }

    public WebElement getTerms() {
        return terms;
    }

    public WebElement getCheckout() {
        return checkout;
    }

    public WebElement getRemoveGiftCard() {
        return removeGiftCard;
    }

    public WebElement getRemoveLaptop() {
        return removeLaptop;
    }

    public WebElement getUpdateCart() {
        return updateCart;
    }

    public WebElement getEmptyCarMessage() {
        return emptyCarMessage;
    }

    public ShoppingCar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
