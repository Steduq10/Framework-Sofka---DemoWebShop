package co.com.client.webproject.test.controllers.shoppingcar;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.LandingPage;
import co.com.client.webproject.test.page.ShoppingCar;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class RemoveProductsWebController {

    private WebAction webAction;


    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void removeProducts(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());
            ShoppingCar shoppingCar = new ShoppingCar(webAction.getDriver());
            webAction.click(landingPage.getShoppingCar(),2,true);
            webAction.click(shoppingCar.getRemoveGiftCard(),2,true);
            webAction.click(shoppingCar.getRemoveLaptop(),2,true);
            webAction.click(shoppingCar.getUpdateCart(),2,true);


        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar crear la cuenta",e);
        }
    }
}
