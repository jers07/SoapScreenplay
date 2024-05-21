package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.ui.PageLogin.*;

public class LlenarRegistro implements Task {

    String nombre;
    String correo;


    public LlenarRegistro conElNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public LlenarRegistro yElCorreo(String correo){
        this.correo=correo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CAMPO_USER),
                Enter.theValue(correo).into(CAMPO_CORREO),
                Click.on(BOTON_ACCEPT)
        );
    }

    public static LlenarRegistro llenarRegistro(){
        return new LlenarRegistro();
    }
}
