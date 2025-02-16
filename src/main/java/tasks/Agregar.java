package tasks;

import models.setdata.EmpleadoLoombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static userinterfaces.FormularioPage.*;

public class Agregar implements Task {

    private final EmpleadoLoombokData empleadoLoombokData;

    public Agregar(EmpleadoLoombokData empleadoLoombokData) {
        this.empleadoLoombokData = empleadoLoombokData;
    }


    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(BTN_PIM, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_PIM),
                Click.on(BTN_ADD),
                Enter.theValue(empleadoLoombokData.getNombre()).into(TXT_FIRST_NAME),
                Enter.theValue(empleadoLoombokData.getSegundoNombre()).into(TXT_MIDDLE_NAME),
                Enter.theValue(empleadoLoombokData.getApellido()).into(TXT_lAST_NAME),
                Click.on(TXT_ID),
                SendKeys.of(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).into(TXT_ID),
                Enter.theValue(empleadoLoombokData.getIdEmpleado()).into(TXT_ID)

        );

        // Guardar valores en el actor
        actor.remember("nombreEmpleado", empleadoLoombokData.getNombre());
        actor.remember("idEmpleado", empleadoLoombokData.getIdEmpleado());

    }
    public static Agregar empleado(EmpleadoLoombokData empleadoLoombokData) {
        return Instrumented.instanceOf(Agregar.class).withProperties(empleadoLoombokData);
    }

}

