package steps.SignUp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.Home.HomePage;
import pages.SingUp.SignUpPage;
import steps.Hook;

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
        SignUpPage.signUpUnico(username,password);
    }

    @Cuando("Ingresa nombre de usuario y contraseña ya registrados {string} {string}")
    public void ingresaNombreDeUsuarioYContrasenaYaRegistrados(String username, String password) throws Exception {
        SignUpPage.signUpYaRegistrados(username,password);
    }

    @Entonces("Se registra el usuario correctamente {string}")
    public void seRegistraElUsuarioCorrectamente(String alert) throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarTextAlerta(alert);
        Hook.captura();
    }

    @Entonces("No se permite registrar el usuario {string}")
    public void noSePermiteRegistrarElUsuario(String alert) throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarTextAlerta(alert);
        Hook.captura();
    }


    @Then("Ingresa nombre de usuario y contraseña validos")
    public void ingresaNombreDeUsuarioYContrasenaValidos() throws Exception {
        SignUpPage.registroExitoso();
    }

    @When("Se registra el usuario correctamente")
    public void seRegistraElUsuarioCorrectamente() throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarRegistroExitoso();
        Hook.captura();
    }


    @When("El usuario omite información en uno o más campos obligatorios")
    public void elUsuarioOmiteInformacionEnUnoOMasCamposObligatorios() throws Exception {
        SignUpPage.registroIncompleto();
    }

    @Then("El sistema debe mostrar un mensaje de error indicando los campos que deben ser completados")
    public void elSistemaDebeMostrarUnMensajeDeErrorIndicandoLosCamposQueDebenSerCompletados() throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarUsuarioContraseñaIncompleto();
        Hook.captura();
    }

    @When("El usuario completa todos los campos obligatorios con información válida y envía el formulario")
    public void elUsuarioCompletaTodosLosCamposObligatoriosConInformacionValidaYEnviaElFormulario() throws Exception {
        SignUpPage.registroExitoso();
    }

    @Then("El usuario debe ser redirigido a una página de bienvenida con un mensaje de registro exitoso")
    public void elUsuarioDebeSerRedirigidoAUnaPaginaDeBienvenidaConUnMensajeDeRegistroExitoso() throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarRegistroExitoso();
        Hook.captura();
    }

    @When("El usuario ingresa un correo electrónico que ya está en uso")
    public void elUsuarioIngresaUnCorreoElectronicoQueYaEstaEnUso() throws Exception {
        SignUpPage.emailRegistrado();
    }

    @Then("El sistema debe mostrar un mensaje de error en pantalla indicando que ya está registrado.")
    public void elSistemaDebeMostrarUnMensajeDeErrorEnPantallaIndicandoQueYaEstaRegistrado() throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarRegistroExistente();
        Hook.captura();
    }

    @When("El usuario ingresa una contraseña que no cumple con los criterios de seguridad establecidos")
    public void elUsuarioIngresaUnaContrasenaQueNoCumpleConLosCriteriosDeSeguridadEstablecidos() throws Exception {
        SignUpPage.passwordDebilEnRegistro();
    }

    @Then("El sistema debe mostrar un mensaje de error indicando que la contraseña no es lo suficientemente segura")
    public void elSistemaDebeMostrarUnMensajeDeErrorIndicandoQueLaContrasenaNoEsLoSuficientementeSegura() throws InterruptedException {
        SignUpPage.validarPresenciaAlerta();
        SignUpPage.validarPasswordDebil();
        Hook.captura();
    }
}
