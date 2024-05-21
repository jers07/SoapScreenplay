package co.com.sofka.stepdefinitions.soapservices;

import co.com.sofka.stepdefinitions.SetupService;
import io.cucumber.java.en.*;
import org.jetbrains.annotations.NotNull;

import static co.com.sofka.tasks.services.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.getBody;
import static co.com.sofka.utils.ArchivosUtil.readFile;

public class SoapDivisionStepDefinition extends SetupService {
    int valueUno;
    int valueDos;

    @Given("que el usuario quiere dividir {int} con el numero {int}")
    public void queElUsuarioQuiereDividirConElNumero(Integer numeroUno, Integer numeroDos) {
        super.setupService("http://www.dneonline.com/");
        valueUno = numeroUno;
        valueDos = numeroDos;
    }
    @When("hace la peticion de divicion")
    public void haceLaPeticionDeDivicion() {
        actor.attemptsTo(
                doPost().withTheResource("calculator.asmx")
                        .andHeaders(super.headers("Divide"))
                        .andTheBody(getBody(valueUno,valueDos, "division.xml"))
        );
    }

}
