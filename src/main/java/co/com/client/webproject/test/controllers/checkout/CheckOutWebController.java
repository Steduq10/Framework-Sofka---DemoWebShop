package co.com.client.webproject.test.controllers.checkout;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CheckOut;
import co.com.client.webproject.test.page.RegisterPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CheckOutWebController {

    private WebAction webAction;
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void confirmOrder(){
        try{
            CheckOut checkOut = new CheckOut(webAction.getDriver());
            webAction.click(checkOut.getBillingContinue(),2,true);
            webAction.click(checkOut.getShippingContinue(),2,true);
            webAction.click(checkOut.getShippingMethodContinue(),2,true);
            webAction.click(checkOut.getPaymentMethodContinue(),2,true);
            webAction.click(checkOut.getPaymentInformationContinue(),2,true);
            webAction.click(checkOut.getConfirmOrder(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar confirmar la orden",e);
        }
    }
}
