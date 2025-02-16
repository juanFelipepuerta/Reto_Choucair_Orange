package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormularioPage {
    FormularioPage() {}

    public static final Target BTN_PIM = Target.the("Botón de menu para visualizar empleados existentes")
            .locatedBy("//ul[@class='oxd-main-menu']/li[2]");

    public static final Target BTN_ADD = Target.the("Botón que redirreciona a la opcion de agregar un empleado")
            .locatedBy("//button[@type='button'][contains(.,'Add')]");

    public static final Target TXT_FIRST_NAME = Target.the("Campo de texto para ingresar el nombre")
            .located(By.name("firstName"));

    public static final Target TXT_MIDDLE_NAME = Target.the("Campo de texto para ingresar el segundo nombre")
            .located(By.name("middleName"));

    public static final Target TXT_lAST_NAME = Target.the("Campo de texto para ingresar el apellido")
            .located(By.name("lastName"));

    public static final Target TXT_ID = Target.the("Campo de texto para ingresar el id del empleado")
            .locatedBy("//label[text()='Employee Id']/following::input[1]");


}


