package co.com.client.webproject.test.controllers.checkout;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CheckOut;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class ValidateInformationWebController {

    private WebAction webAction;
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void validateInformation(){
        String billingAddress = "";
        String shippingAddress = "";
        String paymentInformation = "";
        String name = "";
        String email = "";
        String address1 = "";
        String phone = "";
        String country = "";

        List<String> information = new ArrayList<>();

        try{
            CheckOut checkOut = new CheckOut(webAction.getDriver());
          billingAddress =  webAction.getText(checkOut.getBillingAddress(),2,true);
            webAction.click(checkOut.getBillingContinue(),2,true);

          shippingAddress =  webAction.getText(checkOut.getShippingAddress(),2,true );
            webAction.click(checkOut.getShippingContinue(),2,true);


            webAction.click(checkOut.getShippingContinue(),2,true);

            webAction.click(checkOut.getPaymentMethodContinue(),2,true);

           paymentInformation = webAction.getText(checkOut.getPaymentInformation(),2,true);  //You will pay by COD
            webAction.click(checkOut.getPaymentInformationContinue(),2,true);

           name = webAction.getText(checkOut.getName(),2,true);
           email = webAction.getText(checkOut.getEmail(),2,true);
           address1 = webAction.getText(checkOut.getAddress1(),2,true);
           phone  = webAction.getText(checkOut.getPhone(),2,true);
           country = webAction.getText(checkOut.getCountry(),2,true);

           information.add(billingAddress);
           information.add(shippingAddress);
           information.add(paymentInformation);
           information.add(name);
           information.add(email);
           information.add(address1);
           information.add(phone);
           information.add(country);


        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar confirmar la orden",e);
        }
    }
}
