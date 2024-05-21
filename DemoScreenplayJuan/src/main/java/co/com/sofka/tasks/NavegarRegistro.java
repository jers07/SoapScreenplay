package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.ui.PageLogin.BOTON_SIGN_UP;

public class NavegarRegistro implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_SIGN_UP)
        );
    }

    public static NavegarRegistro navegarAlRegistro(){
        return new NavegarRegistro();
    }
}
