package co.com.client.webproject.test.controllers.shoppingcar;

import co.com.client.webproject.test.page.MyAccountPage;
import co.com.client.webproject.test.page.ShoppingCar;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class ProductsAddedWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public List<String> getProductsName(){
        String giftcard = "";
        String laptop = "";
        List<String> products = new ArrayList<>();
        try {
            ShoppingCar shoppingCar = new ShoppingCar(webAction.getDriver());
            giftcard = webAction.getText(shoppingCar.getGiftCard(), 2, true);
            laptop = webAction.getText(shoppingCar.getLaptop(),2,true);
            products.add(giftcard);
            products.add(laptop);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar validar el nombre de los productos " +
                    "registrados en el carrito de compras", e);
        }
        return products;
    }
}
