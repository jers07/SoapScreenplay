package co.com.sofka.stepdefinitions.soapservices;

import co.com.sofka.stepdefinitions.SetupService;
import io.cucumber.java.en.*;
import org.jetbrains.annotations.NotNull;

import static co.com.sofka.tasks.services.DoPost.doPost;
import static co.com.sofka.utils.ArchivosUtil.getBody;
import static co.com.sofka.utils.ArchivosUtil.readFile;

public class SoapMultiplicacionStepDefinition extends SetupService {
    int valueUno;
    int valueDos;

    @Given("que el usuario quiere multiplicar {int} con el numero {int}")
    public void queElUsuarioQuiereMultiplicarConElNumero(Integer numeroUno, Integer numeroDos) {
        super.setupService("http://www.dneonline.com/");
        valueUno = numeroUno;
        valueDos = numeroDos;

    }

    @When("hace la peticion de multiplicar")
    public void haceLaPeticionDeMultiplicar() {
        actor.attemptsTo(
                doPost().withTheResource("calculator.asmx")
                        .andHeaders(super.headers("Multiply"))
                        .andTheBody(getBody(valueUno,valueDos, "multiplicacion.xml"))
        );
    }
}
