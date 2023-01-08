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
      //  String name = "";
       // String email = "";
        String error = "";
       // String confirmation = "";


      //  List<String> enquiryInformation = new ArrayList<>();

        try{
            ContactUs contactUs = new ContactUs(webAction.getDriver());
          //  name =  webAction.getText(contactUs.getFullname(),2,true);
            //email =  webAction.getText(contactUs.getEmail(),2,true);
            error = webAction.getText(contactUs.getValidationError(),2,true);
            //confirmation = webAction.getText(contactUs.getConfirmation(),2,true);


         //   enquiryInformation.add(name);
         //   enquiryInformation.add(email);
         //   enquiryInformation.add(error);
          //  enquiryInformation.add(confirmation);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar validar la peticion",e);
        }
        return error;
    }
}
