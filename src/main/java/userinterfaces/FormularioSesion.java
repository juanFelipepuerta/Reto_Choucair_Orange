package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormularioSesion {
    FormularioSesion() {}



    public static final Target BTN_LOGIN_DETAILS = Target.the("Boton para habilitar los datos de sesion")
            .locatedBy("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");
    public static final Target TXT_USER_REGIS = Target.the("campo de texto para escribir el usuario que se va a definir para crear los datos de inicio de sesion")
            .locatedBy("//label[text()='Username']/following::input[1]");

    public static final Target TXT_PASSWORD_REGIS = Target.the("campo de texto para escribir la contrasena que se va a definir para crear los datos de inicio de sesion")
            .locatedBy( "//label[text()='Username']/following::input[4]");

    public static  final  Target TXT_CONFIRM_PASSWORD = Target.the("campo de texto para escribir la confirmacion de la contrasena definida en el paso anterior")
            .locatedBy("//label[text()='Username']/following::input[5]");

    public static  final  Target BTN_SAVE = Target.the("Boton para guardar el registro de un nuevo empleado")
            .locatedBy("//button[@type='submit'][contains(.,'Save')]");

}
