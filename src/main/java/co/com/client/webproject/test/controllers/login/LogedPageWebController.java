package co.com.client.webproject.test.controllers.login;

import co.com.client.webproject.test.page.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LogedPageWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String getEmailUserRegistered(){

        String email = "";
        try {
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());
            email = webAction.getText(myAccountPage.getRegisteredEmail(),2,true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el mensaje", e);
        }
        return email;
    }
}
