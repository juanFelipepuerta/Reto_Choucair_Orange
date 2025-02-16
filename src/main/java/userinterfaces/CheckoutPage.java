package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;


public class CheckoutPage {
    CheckoutPage() {}

    public static final Target TXT_CONFIRMAR = Target.the("texto a validar registro de empleado")
            .locatedBy("(//p[contains(@class, 'oxd-text--toast-message')])[1]");


}
