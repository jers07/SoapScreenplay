package co.com.sofka.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.sofka.questions.ObtenerMensaje.obtenerMensaje;
import static co.com.sofka.tasks.AbrirPaginaInicial.abrirPagina;
import static co.com.sofka.tasks.LlenarRegistro.llenarRegistro;
import static co.com.sofka.tasks.NavegarRegistro.navegarAlRegistro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CarritoStepDefinition extends Setup {

    @Dado("que el usuario {string} se encuentra en el sitio web")
    public void queElUsuarioSeEncuentraEnElSitioWeb(String actor) {
        actorSetupTheBrowser(actor);
        theActorInTheSpotlight().wasAbleTo(
                abrirPagina().conLaUrl("https://automationexercise.com/")
        );
    }


    @Cuando("se registra e inicia sesion en la plataforma con el usuario {string} y el correo {string}")
    public void seRegistraEIniciaSesionEnLaPlataformaConElUsuarioYElCorreo(String usuario, String correo) {
        theActorInTheSpotlight().attemptsTo(
                navegarAlRegistro(),
                llenarRegistro()
                        .conElNombre(usuario)
                        .yElCorreo(correo)
        );
    }


    @Cuando("selecciona los productos finalizando su compra")
    public void seleccionaLosProductosFinalizandoSuCompra() {


    }

    @Entonces("debería visualizar un mensaje con la informacion de su orden")
    public void deberíaVisualizarUnMensajeConLaInformacionDeSuOrden() {

        theActorInTheSpotlight().should(
                seeThat(obtenerMensaje(), equalTo("ENTER ACCOUNT INFORMATION"))
        );

    }
}
