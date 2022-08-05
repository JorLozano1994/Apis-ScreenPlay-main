package stepdefinitions;


import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;
import questions.LastResponseStatusCode;
import questions.Valida;
import task.Consumo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ApisStepDefinitions extends PageObject {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setStage() {
        OnStage.setTheStage(new Cast());
    }



    @Given("^consumo el api (.+) para verificar la peticion (.+), con la siguiente data de prueba:$")
    public void consumoElApiParaVerificarLaPeticionConLaSiguienteDataDePrueba(String api, String peticion, DataTable datosPeticion) throws IOException {

        List<String> datos = datosPeticion.topCells();
        String url, endpoint, metodo;
        endpoint = datos.get(1);
        url = environmentVariables.getProperty(datos.get(0))+endpoint;
        metodo = datos.get(2);
        OnStage.theActorCalled("Operador/ambos").wasAbleTo(
                Consumo.elApi(metodo, url));
    }
    @When("^verifico el status code (\\d+)$")
    public void verificoElStatusCode(int sc) {
        OnStage.theActorInTheSpotlight().should(seeThat("El status code: ", LastResponseStatusCode.is(), equalTo(sc)));
    }
    @Then("^Verifico los valores esperados en el response (.+)$")
    public void verificoLosValoresEsperadosEnElResponse(String valoresEsperados) {
        List<String> responsePaths = new ArrayList<String>();
        List<String> respuestaEsperada = new ArrayList<String>();
        OnStage.theActorInTheSpotlight().should(seeThat("Respuesta esperada"
                , Valida.bodyRespuesta(responsePaths)
                , equalTo(respuestaEsperada)));
    }


}
