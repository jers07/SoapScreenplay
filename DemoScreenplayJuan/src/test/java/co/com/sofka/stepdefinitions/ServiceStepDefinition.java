package co.com.sofka.stepdefinitions;

import co.com.sofka.models.ModeloPost;
import co.com.sofka.questions.services.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ServiceStepDefinition extends SetupService {
    public static final ModeloPost modeloPost = new ModeloPost();

    @Given("que el usuario esta en la pagina de {string}")
    public void queElUsuarioEstaEnLaPaginaDe(String baseUrl) {
        setupService(baseUrl);
    }


    @Then("deberia obtener un codigo de respuesta {int}")
    public void deberiaObtenerUnCodigoDeRespuesta(Integer statusCode) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(statusCode)
                )
        );

    }





}
