package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FormularioBusqueda {
    FormularioBusqueda() {}

    public static final Target TXT_SEARCH_NAME = Target.the("Campo búsqueda por nombre")
            .locatedBy("(//input[@placeholder='Type for hints...'])[1]");

    public static final Target TXT_SEARCH_ID = Target.the("Campo búsqueda por nombre")
            .locatedBy("(//input[contains(@class,'oxd-input oxd-input--active')])[2]");
    public static final Target BTN_SEARCH = Target.the("Campo búsqueda por nombre")
            .locatedBy("//button[@type='submit'][contains(.,'Search')]");

    public static final Target LBL_RESULTADO_NOMBRE = Target.the("Label paa confirmar registro por nombre")
            .locatedBy("(//div[contains(.,'Juan Felipe')])[13]");

    public static final Target LBL_RESULTADO_ID = Target.the("Label para confirmar registro por id")
            .locatedBy("(//div[contains(.,'1890')])[13]");



}
