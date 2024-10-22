package steps.Home;

import io.cucumber.java.en.Given;
import io.cucumber.java.es.Dado;
import pages.Home.HomePage;

public class HomeSteps {
    @Dado("Un usuario no registrado se desea registrar a la página web de la empresa")
    public void unUsuarioNoRegistradoSeDeseaRegistrarALaPaginaWebDeLaEmpresa() throws Exception {
        HomePage.ClickSignUp();
    }

    @Given("El usuario está en la página de registro")
    public void elUsuarioEstaEnLaPaginaDeRegistro() throws Exception {
        HomePage.ClickSignUp();
    }
}
