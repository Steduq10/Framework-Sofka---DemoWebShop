package co.com.client.webproject.test.controllers.contactus;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.ContactUs;
import co.com.client.webproject.test.page.LandingPage;
import co.com.client.webproject.test.page.products.GiftCard;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsWebController {

    private WebAction webAction;
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void sendEnquiry(){
        try{
            ContactUs contactUs = new ContactUs(webAction.getDriver());
            webAction.sendText(contactUs.getEnquiry(),"You are the best site on the web",2,true);
            webAction.click(contactUs.getSubmitButton(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar enviar una petición",e);
        }
    }
}
