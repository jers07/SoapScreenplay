package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import static co.com.sofka.questions.services.ReturnResponse.returnResponse;
import static co.com.sofka.tasks.services.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class GetStepDefinition extends SetupService {

    @When("envia una peticion de tipo get al recurso {string}")
    public void enviaUnaPeticionDeTipoGetAlRecurso(String recurso) {
        actor.attemptsTo(
                doGet().withTheResource(recurso)
        );

    }


    @Then("deberia obtener una lista con la información de los usuarios")
    public void deberiaObtenerUnaListaConLaInformacionDeLosUsuarios() {
        String nuevo = new String(LastResponse.received().answeredBy(actor).asByteArray(),
                StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(nuevo);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        System.out.println("****///***/***//*/*/*");
        JSONObject jsonObject1 =(JSONObject)jsonArray.get(0);
        System.out.println(jsonObject1.get("last_name"));

        actor.should(
                seeThat("la respuesta es",
                        returnResponse(), containsString("Ferguson")
                )
        );


    }
}
