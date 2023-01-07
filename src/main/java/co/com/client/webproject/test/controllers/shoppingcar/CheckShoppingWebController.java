package co.com.client.webproject.test.controllers.shoppingcar;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.RegisterPage;
import co.com.client.webproject.test.page.ShoppingCar;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CheckShoppingWebController {

    private WebAction webAction;
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void checkShoppingCar(){
        try{
            ShoppingCar shoppingCar = new ShoppingCar(webAction.getDriver());
            webAction.click(shoppingCar.getCountry(),2,true);
            webAction.moveTo(shoppingCar.getCountrySelected(),2,true);
            webAction.click(shoppingCar.getCountrySelected(),2,true);
            webAction.click(shoppingCar.getTerms(),2,true);
            webAction.click(shoppingCar.getCheckout(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar crear la cuenta",e);
        }
    }
}
