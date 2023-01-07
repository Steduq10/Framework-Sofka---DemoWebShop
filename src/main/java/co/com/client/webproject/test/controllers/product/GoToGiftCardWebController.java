package co.com.client.webproject.test.controllers.product;

import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class GoToGiftCardWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;}

    public void goToGiftCardPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getGiftCard(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió un error al intentar ir a la página del producto",e);
        }
    }
}
