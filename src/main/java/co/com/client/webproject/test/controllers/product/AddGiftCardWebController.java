package co.com.client.webproject.test.controllers.product;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.LoginPage;
import co.com.client.webproject.test.page.products.GiftCard;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class AddGiftCardWebController {
    private WebAction webAction;
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void addGiftCardToCar(){
        try{
            GiftCard giftCard = new GiftCard(webAction.getDriver());
            webAction.sendText(giftCard.getName(),customer.getEmail(),2,true);
            webAction.sendText(giftCard.getEmail(),customer.getPassword(),2,true);
            webAction.sendText(giftCard.getMessage(),"This is a giftcard for you",2,true);
            webAction.click(giftCard.getAddToCar(),2,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar agregar el producto al carrito de compras",e);
        }
    }
}
