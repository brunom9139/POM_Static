package steps.LogIn;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.Home.HomePage;
import pages.LogIn.LogInPage;
import steps.Hook;

public class LogInSteps {
    @Dado("Un usuario registrado se desea loguear a la página web de la empresa")
    public void unUsuarioRegistradoSeDeseaLoguearALaPaginaWebDeLaEmpresa() throws Exception {
        HomePage.ClickLogIn();
    }

    @Cuando("Ingresa nombre de usuario y contraseña validos en login {string} {string}")
    public void ingresaNombreDeUsuarioYContrasenaValidosEnLogin(String username, String password) throws Exception {
        LogInPage.LogIn(username,password);
    }

    @Cuando("Ingresa nombre de usuario y contraseña invalidos {string} {string}")
    public void ingresaNombreDeUsuarioYContrasenaInvalidos(String username, String password) throws Exception {
        LogInPage.LogIn(username,password);
    }

    @Dado("Un usuario logueado en la página web de la empresa {string} {string}")
    public void unUsuarioLogueadoEnLaPaginaWebDeLaEmpresa(String username, String password) throws Exception {
        LogInPage.LogIn2(username,password);
    }

    @Entonces("Se loguea en la pagina correctamente {string}")
    public void seLogueaEnLaPaginaCorrectamente(String login) {
        HomePage.ValidateLogin(login);
        Hook.captura();
    }

    @Entonces("No se loguea informando la situación {string}")
    public void noSeLogueaInformandoLaSituacion(String alert) {
        LogInPage.ValidateNoLogin(alert);
        Hook.captura();
    }
}
