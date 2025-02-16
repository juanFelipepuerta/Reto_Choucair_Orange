package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    LoginPage() {}

    public static final Target TXT_USER = Target.the("campo de texto para escribir usuario")
            .locatedBy("//input[contains(@name,'username')]");

    public static final Target TXT_PASSWORD = Target.the("campo de texto para escribir contrasena")
            .locatedBy( "//input[@name='password']");

    public static  final  Target BTN_LOGIN = Target.the("Boton enviar  credenciales login ")
            .locatedBy("//button[contains(.,'Login')]");


}
