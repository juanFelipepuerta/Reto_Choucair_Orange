package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import static userinterfaces.FormularioBusqueda.*;
import static userinterfaces.FormularioPage.BTN_PIM;

public class BuscarEmpleado implements Task {

    public static Performable enPIM() {
        return new BuscarEmpleado();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Recuperar valores guardados
        String nombre = actor.recall("nombreEmpleado");
        String idEmpleado = actor.recall("idEmpleado");

        actor.attemptsTo(
                WaitUntil.the(BTN_PIM, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_PIM),
                WaitUntil.the(TXT_SEARCH_NAME, isClickable()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombre).into(TXT_SEARCH_NAME),
                Enter.theValue(idEmpleado).into(TXT_SEARCH_ID),
                Click.on(BTN_SEARCH)
        );
    }
}
