package co.com.client.webproject.test.stepdefinition.peticionvacia;

import co.com.client.webproject.test.controllers.contactus.ContactUsEmptyWebController;
import co.com.client.webproject.test.controllers.contactus.GoContactUsController;
import co.com.client.webproject.test.controllers.contactus.ValidateEmptyEnquiryWebController;
import co.com.client.webproject.test.controllers.login.GoLoginPageWebController;
import co.com.client.webproject.test.controllers.login.LoginPageWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.stepdefinition.GeneralSetUp;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class PeticionVaciaSteps extends GeneralSetUp {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
        customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
    }
    @Dado("que el cliente ingresa al landing page y luego se loguea con  credenciales de usuario")
    public void queElClienteIngresaAlLandingPageYLuegoSeLogueaConCredencialesDeUsuario() {

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

    @Cuando("el cliente se dirige a la zona de contact Us")
    public void elClienteSeDirigeALaZonaDeContactUs() {
        GoContactUsController goContactUsController = new GoContactUsController();
        goContactUsController.setWebAction(webAction);
        goContactUsController.goToContactUs();
    }

    @Y("realiza la peticion con el campo de enquiry vacio")
    public void realizaLaPeticionConElCampoDeEnquiryVacio() {
        ContactUsEmptyWebController contactUsEmptyWebController = new ContactUsEmptyWebController();
        contactUsEmptyWebController.setWebAction(webAction);
        contactUsEmptyWebController.sendEmptyEnquiry();

    }

    @Entonces("como resultado el usuario recibira un mensaje de alerta solicitando que ingrese el enquiry")
    public void comoResultadoElUsuarioRecibiraUnMensajeDeAlertaSolicitandoQueIngreseElEnquiry() {
        ValidateEmptyEnquiryWebController validateEmptyEnquiryWebController = new ValidateEmptyEnquiryWebController();
        validateEmptyEnquiryWebController.setWebAction(webAction);
        validateEmptyEnquiryWebController.validateEmptyEnquiry();

        Assert.Hard.thatString(validateEmptyEnquiryWebController.validateEmptyEnquiry())
                .contains("Enter enquiry");
    }
}
