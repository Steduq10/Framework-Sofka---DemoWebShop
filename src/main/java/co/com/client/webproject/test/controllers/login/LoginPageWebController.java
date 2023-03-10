package co.com.client.webproject.test.controllers.login;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.LoginPage;
import co.com.client.webproject.test.page.RegisterPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LoginPageWebController {

    private WebAction webAction;
   // private Customer customer;

//    public void setCustomer(Customer customer) {
  //      this.customer = customer;
  //  }

    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }

    public void fillLoginForm(){
        try{
            LoginPage loginPage = new LoginPage(webAction.getDriver());
            //webAction.click(loginPage.getEmail(),10,false);
            webAction.sendText(loginPage.getEmail(),"platonsocrates@mail.com",10,true);
           // webAction.click(loginPage.getPassword(),10,false);
            webAction.sendText(loginPage.getPassword(),"platon",10,true);
            webAction.click(loginPage.getLoginButton(),5,true);
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar loguearse",e);
        }
    }

}
