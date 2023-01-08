package co.com.client.webproject.test.stepdefinition.eliminarproductos;

import co.com.client.webproject.test.controllers.login.GoLoginPageWebController;
import co.com.client.webproject.test.controllers.login.LoginPageWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.controllers.product.AddGiftCardWebController;
import co.com.client.webproject.test.controllers.product.AddLaptopWebController;
import co.com.client.webproject.test.controllers.product.GoToGiftCardWebController;
import co.com.client.webproject.test.controllers.shoppingcar.RemoveProductsWebController;
import co.com.client.webproject.test.controllers.shoppingcar.ValidateEmptyShoppingCarWebController;
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

public class EliminarProductosSteps extends GeneralSetUp {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }


    @Dado("que el cliente ingresa al landingpage y luego ingresa con sus credenciales de usuario")
    public void queElClienteIngresaAlLandingpageYLuegoIngresaConSusCredencialesDeUsuario() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        GoLoginPageWebController goLoginPageWebController = new GoLoginPageWebController();
        goLoginPageWebController.setWebAction(webAction);
        goLoginPageWebController.goToLoginPage();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        //loginPageWebController.setCustomer(customer);
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.fillLoginForm();
    }

    @Cuando("el cliente agrega productos al carrito de compras")
    public void elClienteAgregaProductosAlCarritoDeCompras() {

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

    @Y("luego decide removerlos del carrito de compras")
    public void luegoDecideRemoverlosDelCarritoDeCompras() {

        RemoveProductsWebController removeProductsWebController = new RemoveProductsWebController();
        removeProductsWebController.setWebAction(webAction);
        removeProductsWebController.removeProducts();
    }

    @Entonces("como resultado el usuario ve que el producto ya no se encuentra en el carrito o el carrito se encuentra vacio")
    public void comoResultadoElUsuarioVeQueElProductoYaNoSeEncuentraEnElCarritoOElCarritoSeEncuentraVacio() {

        ValidateEmptyShoppingCarWebController validateEmptyShoppingCarWebController = new ValidateEmptyShoppingCarWebController();
        validateEmptyShoppingCarWebController.setWebAction(webAction);
        validateEmptyShoppingCarWebController.getEmptyCarMessage();

        Assert.Hard.thatString(validateEmptyShoppingCarWebController.getEmptyCarMessage()).contains("Your Shopping Cart is empty!");

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
