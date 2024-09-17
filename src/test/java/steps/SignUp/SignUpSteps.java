package steps.SignUp;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.Home.HomePage;
import pages.SingUp.SignUpPage;

public class SignUpSteps {

    @Dado("Un usuario registrado se desea registrar a la página web de la empresa")
    public void unUsuarioRegistradoSeDeseaRegistrarALaPaginaWebDeLaEmpresa() throws Exception {
        HomePage.ClickSignUp();
    }

    @Cuando("Ingresa nombre de usuario y contraseña validos {string} {string}")
    public void ingresaNombreDeUsuarioYContrasenaValidos(String username, String password) throws Exception {
        SignUpPage.signUpUnico(username,password);
    }

    @Cuando("Ingresa nombre de usuario y contraseña incorrectos o inválidos {string} {string}")
    public void ingresaNombreDeUsuarioYContrasenaIncorrectosOInvalidos(String username, String password) throws Exception {
        SignUpPage.signUpYaRegistrados(username,password);
    }

    @Cuando("Ingresa nombre de usuario y contraseña ya registrados {string} {string}")
    public void ingresaNombreDeUsuarioYContrasenaYaRegistrados(String username, String password) throws Exception {
        SignUpPage.signUpYaRegistrados(username,password);
    }

    @Entonces("Se registra el usuario correctamente {string}")
    public void seRegistraElUsuarioCorrectamente(String alert) throws Exception {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarTextAlerta(alert);
    }

    @Entonces("No se permite registrar el usuario {string}")
    public void noSePermiteRegistrarElUsuario(String alert) throws Exception {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarTextAlerta(alert);
    }


}
