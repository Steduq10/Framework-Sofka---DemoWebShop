package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {

    @CacheLookup
    @FindBy(id = "FullName")
    WebElement fullname;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "Enquiry")
    WebElement enquiry;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[3]/input")
    WebElement submitButton;

    @CacheLookup
    @FindBy(xpath = "//span[@class='field-validation-error'] //span")
    WebElement validationError;

    @CacheLookup
    @FindBy(className = "result")
    WebElement confirmation;



    public WebElement getFullname() {
        return fullname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getEnquiry() {
        return enquiry;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getValidationError() {
        return validationError;
    }

    public WebElement getConfirmation() {
        return confirmation;
    }

    public ContactUs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
