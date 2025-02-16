package tasks;
import models.setdata.DatosSesionLoombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static userinterfaces.CheckoutPage.TXT_CONFIRMAR;
import static userinterfaces.FormularioSesion.*;

public class Ingresar implements Task {

    private final DatosSesionLoombokData datosSesionLoombokData;

    public Ingresar(DatosSesionLoombokData datosSesionLoombokData) {
        this.datosSesionLoombokData = datosSesionLoombokData;
    }


    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(



                Click.on(BTN_LOGIN_DETAILS),
                Enter.theValue(datosSesionLoombokData.getNombreUsuario()).into(TXT_USER_REGIS),
                Enter.theValue(datosSesionLoombokData.getContrasenaRegistro()).into(TXT_PASSWORD_REGIS),
                Enter.theValue(datosSesionLoombokData.getContrasenaRegistro()).into(TXT_CONFIRM_PASSWORD),
                Click.on(BTN_SAVE),
                WaitUntil.the(TXT_CONFIRMAR, isClickable()).forNoMoreThan(10).seconds()


        );

    }

    public static Ingresar datos(DatosSesionLoombokData datosSesionLoombokData) {
        return Instrumented.instanceOf(Ingresar.class).withProperties(datosSesionLoombokData);
    }

}
