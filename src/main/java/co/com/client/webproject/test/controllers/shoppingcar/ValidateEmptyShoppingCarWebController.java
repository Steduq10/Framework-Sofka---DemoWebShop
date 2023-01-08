package co.com.client.webproject.test.controllers.shoppingcar;

import co.com.client.webproject.test.page.ShoppingCar;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class ValidateEmptyShoppingCarWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String getEmptyCarMessage(){
        String message = "";

        try {
            ShoppingCar shoppingCar = new ShoppingCar(webAction.getDriver());
            message = webAction.getText(shoppingCar.getEmptyCarMessage(), 2, true);


        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el carro de compras vacio", e);
        }
        return message;
    }
}
