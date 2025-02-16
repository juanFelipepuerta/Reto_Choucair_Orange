package com.co.choucair.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Constantes;
import models.setdata.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import questions.ValidarTexto;
import tasks.Autenticarse;
import tasks.Agregar;
import tasks.BuscarEmpleado;
import tasks.Ingresar;


import static userinterfaces.CheckoutPage.TXT_CONFIRMAR;
import static userinterfaces.FormularioBusqueda.LBL_RESULTADO_NOMBRE;
import static userinterfaces.FormularioBusqueda.LBL_RESULTADO_ID;


public class RegistroEmpleadoStepDefinitions {


    @Given("el actor ingresa a la pagina de OrangeHRM")
    public void elActorIngresaALaPaginaDeOrangeHRM(DataTable table) {
        OnStage.theActorCalled(Constantes.ACTOR).wasAbleTo(Open.url(AbrirLoombokData.setData(table).get(0).getUrl()));

    }

    @When("el actor se autentica con la siguiente informacion")
    public void elActorSeAutenticaConLaSiguienteInformacion(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(AutenticarseLoombokData.setData(table).get(0)));
    }

    @And("el actor accede a PIM y agrega un empleado")
    public void elActorAccedeAPIMYAgregaUnEmpleado(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Agregar.empleado(EmpleadoLoombokData.setData(table).get(0)));
    }

    @And("el actor selecciona create login details para terminar de diligenciar el formulario")
    public void elActorSeleccionaCreateLoginDetailsParaTerminarDediligenciarElFormulario(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ingresar.datos(DatosSesionLoombokData.setData(table).get(0)));

    }

    @Then("se presenta el mensaje se ha creado el registro manera exitosa")
    public void sePresentaElMensajeSeHaCreadoElRegistroManeraExitosa(DataTable table) {

        String textoObtenido = TXT_CONFIRMAR.resolveFor(OnStage.theActorInTheSpotlight()).getText();
        System.out.println("Texto capturado del botón TXT_CONFIRMAR: " + textoObtenido);
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTexto.delElemento(TXT_CONFIRMAR), Matchers.containsString(FinalizarRegistroLoombokData.setData(table).get(0).getMensajeExitoso())));

    }

    @And("el actor accede a PIM y realiza una busqueda del empleado creado anteriormente")
    public void elActorAccedeAPIMYRealizaUnaBusquedaDelEmpleadoCreadoAnteriormente() {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarEmpleado.enPIM());

    }

    @And("se muestra el empleado en los resultados de la búsqueda")
    public void seMuestraElEmpleadoEnLosResultadosDeLaBúsqueda() {


        String textoObtenidoNombre = LBL_RESULTADO_NOMBRE.resolveFor(OnStage.theActorInTheSpotlight()).getText();
        String textoObtenidoID = LBL_RESULTADO_ID.resolveFor(OnStage.theActorInTheSpotlight()).getText();

        System.out.println("Texto capturado del nombre en la tabla: " + textoObtenidoNombre);
        System.out.println("Texto capturado del ID en la tabla: " + textoObtenidoID);

        String nombreEsperado = OnStage.theActorInTheSpotlight().recall("nombreEmpleado");
        String idEsperado = OnStage.theActorInTheSpotlight().recall("idEmpleado");

        System.out.println(" Valor esperado - Nombre: " + nombreEsperado);
        System.out.println(" Valor esperado - ID: " + idEsperado);

        // Validaciones
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidarTexto.delElemento(LBL_RESULTADO_NOMBRE), Matchers.containsString(nombreEsperado)),
                GivenWhenThen.seeThat(ValidarTexto.delElemento(LBL_RESULTADO_ID), Matchers.containsString(idEsperado))
        );

    }


}
