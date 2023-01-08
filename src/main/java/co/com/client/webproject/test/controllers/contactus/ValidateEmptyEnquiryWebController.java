package co.com.client.webproject.test.controllers.contactus;

import co.com.client.webproject.test.page.ContactUs;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ValidateEmptyEnquiryWebController {
    private WebAction webAction;


    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public String validateEmptyEnquiry(){

        String error = "";


        try{
            ContactUs contactUs = new ContactUs(webAction.getDriver());

            error = webAction.getText(contactUs.getValidationError(),2,true);


        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar validar la peticion",e);
        }
        return error;
    }
}
