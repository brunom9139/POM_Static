package steps.Home;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.Home.HomePage;

public class HomeSteps {
    @Entonces("valido que aparece el texto {string}")
    public void validoQueApareceElTexto(String arg0) {

    }


    @Dado("que ingreso el texto {string}")
    public void queIngresoElTexto(String hola) throws Exception {
        HomePage.prueba(hola);
    }
}
