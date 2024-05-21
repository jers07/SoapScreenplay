package co.com.sofka.stepdefinitions.soapservices;

import co.com.sofka.questions.services.ResponseCode;
import co.com.sofka.stepdefinitions.SetupService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import static co.com.sofka.questions.services.ResponseSoap.responseSoap;
import static co.com.sofka.tasks.services.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.getBody;
import static co.com.sofka.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class SoapSumaStepDefinition extends SetupService {
    int valueUno;
    int valueDos;

    @Given("que el es usuario quiere sumar {int} con el numero {int}")
    public void queElEsUsuarioQuiereSumarConElNumero(Integer numeroUno, Integer numeroDos) {
        super.setupService("http://www.dneonline.com/");
        valueUno = numeroUno;
        valueDos = numeroDos;
    }

    @When("hace la peticion de suma")
    public void haceLaPeticionDeSuma() {
        actor.attemptsTo(
                doPost().withTheResource("calculator.asmx")
                        .andHeaders(super.headers("Add"))
                        .andTheBody(getBody(valueUno,valueDos, "suma.xml"))
        );
    }


    @Then("deberia obtener el resultado de {int}")
    public void deberiaObtenerElResultadoDe(Integer resultado) {
        actor.should(
                seeThat("el codigo de respuesta",
                        ResponseCode.was(), equalTo(200)
                ),
                seeThat("el resultado deberia ser",
                        responseSoap(), containsString(resultado+"")
                )
        );
    }
}
