package co.com.client.webproject.test.controllers.order;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CheckOut;
import co.com.client.webproject.test.page.OrderProcessed;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessedWebController {
    private WebAction webAction;


    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public List<String> validateInformation(){
        String orderNumber = "";
        String message = "";


        List<String> processed = new ArrayList<>();

        try{
            OrderProcessed orderProcessed = new OrderProcessed(webAction.getDriver());
            orderNumber =  webAction.getText(orderProcessed.getOrderNumber(),2,true);
            message =  webAction.getText(orderProcessed.getMessageProcessed(),2,true);

                processed.add(orderNumber);
                processed.add(message);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar completar la orden",e);
        }
        return processed;
    }
}
