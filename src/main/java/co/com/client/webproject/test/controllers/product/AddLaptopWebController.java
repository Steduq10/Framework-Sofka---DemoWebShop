package co.com.client.webproject.test.controllers.product;

import co.com.client.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class AddLaptopWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;}

    public void goToLaptopPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            webAction.click(landingPage.getLaptop(),5,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrió un error al intentar agregar el producto al carrito de compras",e);
        }
    }
}
