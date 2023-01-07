package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProcessed {

    @CacheLookup
    @FindBy(className = "title")
    WebElement messageProcessed;

    @CacheLookup
    @FindBy(xpath = "//ul[@class=\"details\"] //li[1]")
    WebElement orderNumber;

    public OrderProcessed(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
