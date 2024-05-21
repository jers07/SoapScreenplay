package co.com.sofka.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import static co.com.sofka.questions.ObtenerRespuesta.obtenerRespuesta;
import static co.com.sofka.questions.services.ReturnResponse.returnResponse;
import static co.com.sofka.stepdefinitions.ServiceStepDefinition.modeloPost;
import static co.com.sofka.tasks.services.DoPost.doPost;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostStepDefinition extends SetupService {
    @When("envia una peticion de tipo Post al recurso {string}")
    public void enviaUnaPeticionDeTipoPostAlRecurso(String recurso) {

        modeloPost.setJob("profesor");
        modeloPost.setName("luis henao");

        actor.attemptsTo(
                doPost()
                        .withTheResource(recurso)
                        .andTheBody(modeloPost)
        );

    }


    @Then("deberia mostrar la información ingresada")
    public void deberiaMostrarLaInformaciónIngresada() {
        actor.should(
                seeThat("su nombre es ",
                        returnResponse(), containsString(modeloPost.getName())
                ),
                seeThat("el campo nombre es ",
                        obtenerRespuesta().delCampo("name") , equalTo(modeloPost.getName()+"a")
                )
        );


        System.out.println("**************");
        String nuevo = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        System.out.println(nuevo);
        JSONObject jsonObject = new JSONObject(nuevo);
        System.out.println(jsonObject.get("name"));
        System.out.println("**************");
    }
}
