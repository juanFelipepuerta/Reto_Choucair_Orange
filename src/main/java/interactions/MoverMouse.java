package interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.awt.*;
import java.awt.event.InputEvent;

/* uso de la clase Actions para presionar teclas
 *
 * en esta interaccion en la linea "action.sendKeys(Keys.ENTER).build().perform();"
 * se presiona la tecla ENTER. En caso de requerir otro tipo de acciones aqui encontraras mas informacion
 *
 * https://www.browserstack.com/guide/action-class-in-selenium
 *
 * */

public class MoverMouse implements Interaction {

    int x;
    int y;

    public MoverMouse(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.mouseMove(x, y);
        // Ejecutando un click
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static MoverMouse enLaPosicion(int x, int y) {
        return Instrumented.instanceOf(MoverMouse.class).withProperties(x, y);
    }
}
