package co.com.client.webproject.test.stepdefinition.ordenexitosa;

import co.com.client.webproject.test.controllers.checkout.CheckOutWebController;
import co.com.client.webproject.test.controllers.login.GoLoginPageWebController;
import co.com.client.webproject.test.controllers.login.LoginPageWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.controllers.order.OrderProcessedWebController;
import co.com.client.webproject.test.controllers.product.AddGiftCardWebController;
import co.com.client.webproject.test.controllers.product.AddLaptopWebController;
import co.com.client.webproject.test.controllers.product.GoToGiftCardWebController;
import co.com.client.webproject.test.controllers.shoppingcar.CheckShoppingWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.stepdefinition.GeneralSetUp;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class OrdenExitosaSteps extends GeneralSetUp {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }
    @Dado("que el cliente ingresa al landingpage y luego se loguea con sus credenciales de usuario")
    public void queElClienteIngresaAlLandingpageYLuegoSeLogueaConSusCredencialesDeUsuario() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        GoLoginPageWebController goLoginPageWebController = new GoLoginPageWebController();
        goLoginPageWebController.setWebAction(webAction);
        goLoginPageWebController.goToLoginPage();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setCustomer(customer);
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.fillLoginForm();
    }

    @Cuando("el cliente agrega productos al carrito")
    public void elClienteAgregaProductosAlCarrito() {
        GoToGiftCardWebController goToGiftCardWebController = new GoToGiftCardWebController();
        goToGiftCardWebController.setWebAction(webAction);
        goToGiftCardWebController.goToGiftCardPage();

        AddGiftCardWebController addGiftCardWebController = new AddGiftCardWebController();
        addGiftCardWebController.setCustomer(customer);
        addGiftCardWebController.setWebAction(webAction);
        addGiftCardWebController.addGiftCardToCar();

        AddLaptopWebController addLaptopWebController = new AddLaptopWebController();
        addLaptopWebController.setWebAction(webAction);
        addLaptopWebController.goToLaptopPage();





    }

    @Y("agrega la informacion de envio y pago")
    public void agregaLaInformacionDeEnvioYPago() {
        CheckShoppingWebController checkShoppingWebController = new CheckShoppingWebController();
        checkShoppingWebController.setCustomer(customer);
        checkShoppingWebController.setWebAction(webAction);
        checkShoppingWebController.checkShoppingCar();

        CheckOutWebController checkOutWebController = new CheckOutWebController();
        checkOutWebController.setCustomer(customer);
        checkOutWebController.setWebAction(webAction);
        checkOutWebController.confirmOrder();
    }

    @Entonces("como resultado el usuario recibira una confirmacion de orden exitosa")
    public void comoResultadoElUsuarioRecibiraUnaConfirmacionDeOrdenExitosa() {
        OrderProcessedWebController orderProcessedWebController = new OrderProcessedWebController();
        orderProcessedWebController.setWebAction(webAction);
        orderProcessedWebController.validateInformation();

        Assert.Hard.thatString(orderProcessedWebController.validateInformation().get(0)).contains("Order number:");
        Assert.Hard.thatString(orderProcessedWebController.validateInformation()
                .get(1)).contains("Your order has been successfully processed!");
    }

    @After
    public void tearDown() throws WebActionsException {
        webAction.pause(5, false);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
