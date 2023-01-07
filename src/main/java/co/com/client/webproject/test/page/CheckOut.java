package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

    @CacheLookup
    @FindBy(id = "billing-address-select")
    WebElement billingAddress;

    @CacheLookup
    @FindBy(xpath = "//*[@id='billing-address-select']/option[1]")
    WebElement optionbilling;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='Billing.save()']")
    WebElement billingContinue;

    @CacheLookup
    @FindBy(id = "shipping-address-select")
    WebElement shippingAddress;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"shipping-address-select\"]/option[1]")
    WebElement optionShipping;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='Shipping.save()']")
    WebElement shippingContinue;

    @CacheLookup
    @FindBy(id = "shippingoption_0")
    WebElement shippingMethod;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
    WebElement shippingMethodContinue;

    @CacheLookup
    @FindBy(id = "paymentmethod_0")
    WebElement paymentMethod;


    @CacheLookup
    @FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
    WebElement paymentMethodContinue;


    @CacheLookup
    @FindBy(xpath = " //div[@class='section payment-info'] //p")
    WebElement paymentInformation;


    @CacheLookup
    @FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
    WebElement paymentInformationContinue;

    //Confirm ORDER
    @CacheLookup
    @FindBy(className = "name")
    WebElement name;

    @CacheLookup
    @FindBy(className = "email")
    WebElement email;

    @CacheLookup
    @FindBy(className = "phone")
    WebElement phone;

    @CacheLookup
    @FindBy(className = "address1")
    WebElement address1;

    @CacheLookup
    @FindBy(className = "city-state-zip")
    WebElement zip;

    @CacheLookup
    @FindBy(className = "country")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
    WebElement confirmOrder;

    public WebElement getBillingAddress() {
        return billingAddress;
    }

    public WebElement getOptionbilling() {
        return optionbilling;
    }

    public WebElement getBillingContinue() {
        return billingContinue;
    }

    public WebElement getShippingAddress() {
        return shippingAddress;
    }

    public WebElement getOptionShipping() {
        return optionShipping;
    }

    public WebElement getShippingContinue() {
        return shippingContinue;
    }

    public WebElement getShippingMethod() {
        return shippingMethod;
    }

    public WebElement getShippingMethodContinue() {
        return shippingMethodContinue;
    }

    public WebElement getPaymentMethod() {
        return paymentMethod;
    }

    public WebElement getPaymentMethodContinue() {
        return paymentMethodContinue;
    }

    public WebElement getPaymentInformation() {
        return paymentInformation;
    }

    public WebElement getPaymentInformationContinue() {
        return paymentInformationContinue;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getZip() {
        return zip;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getConfirmOrder() {
        return confirmOrder;
    }

    public CheckOut(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
