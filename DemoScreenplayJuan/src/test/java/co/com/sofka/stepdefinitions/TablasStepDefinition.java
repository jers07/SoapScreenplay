package co.com.sofka.stepdefinitions;

import co.com.sofka.models.Fecha;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class TablasStepDefinition {

    @Given("el usuario esta en la pagina inicial de demoQA")
    public void elUsuarioEstaEnLaPaginaInicialDeDemoQA() {

    }
    @When("navega hasta la opcion date picker")
    public void navegaHastaLaOpcionDatePicker() {

    }
    @When("selecciona las fechas de los dos campos")
    public void seleccionaLasFechasDeLosDosCampos(List<Fecha> fecha) {
        System.out.println("************");
        System.out.println(fecha.get(0).getHour());
        System.out.println(fecha.get(1).getMonth());
        System.out.println(fecha.get(2).getHour());
        System.out.println("****************");

    }
    @Then("la pagina debera mostrar las fechas seleccionadas")
    public void laPaginaDeberaMostrarLasFechasSeleccionadas() {

    }
}
