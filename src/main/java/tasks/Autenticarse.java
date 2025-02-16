package tasks;

import models.setdata.AutenticarseLoombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.LoginPage.*;

public class Autenticarse implements Task {

    private final AutenticarseLoombokData autenticarseLoombokData;

    public Autenticarse(AutenticarseLoombokData autenticarseLoombokData) {
        this.autenticarseLoombokData = autenticarseLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(autenticarseLoombokData.getUsuario()).into(TXT_USER),
                Enter.theValue(autenticarseLoombokData.getContrasena()).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN)

        );

    }

    public static Autenticarse conCredenciales(AutenticarseLoombokData autenticarseLoombokData) {
        return Instrumented.instanceOf(Autenticarse.class).withProperties(autenticarseLoombokData);
    }
}

