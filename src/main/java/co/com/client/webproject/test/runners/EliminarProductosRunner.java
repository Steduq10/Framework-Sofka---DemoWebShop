package co.com.client.webproject.test.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = {"src/main/resources/features/eliminarproductosdelcarrito.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.eliminarproductos"}
)

public class EliminarProductosRunner {

}
