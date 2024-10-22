package pages.SingUp;

import acciones.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.excel.Data;
import utils.general.RandonStrings;

public class SignUpPage {

    public static final By INPUT_USERNAME = By.id("sign-username");
    public static final By INPUT_PASSWORD = By.id("sign-password");
    public static final By BOTON_SIGN_UP = By.xpath("//button[@onclick='register()']");

    public static void signUpUnico(String username,String password) throws Exception {
        String dataUsernameExcel = Data.get(username);
        String textRandon = RandonStrings.generarCadenaAleatoria(10);
        String usernameFinal = dataUsernameExcel + textRandon;
        Escribir.Escribir(INPUT_USERNAME, usernameFinal);
        Escribir.Escribir(INPUT_PASSWORD, Data.get(password));
        Click.Clickear(BOTON_SIGN_UP);
        EsperarTiempo.esperar(2);
    }

    public static void registroExitoso() throws Exception {
        Escribir.Escribir(INPUT_USERNAME, RandonStrings.generarNombre()+"@gmail.com");
        Escribir.Escribir(INPUT_PASSWORD, RandonStrings.generarPassword());
        Click.Clickear(BOTON_SIGN_UP);
    }

    public static void passwordDebilEnRegistro() throws Exception {
        Escribir.Escribir(INPUT_USERNAME, RandonStrings.generarNombre()+"@gmail.com");
        Escribir.Escribir(INPUT_PASSWORD, RandonStrings.generarPasswordDebil());
        Click.Clickear(BOTON_SIGN_UP);
    }

    public static void emailRegistrado() throws Exception {
        Escribir.Escribir(INPUT_USERNAME, "ecosistemas@gmail.com");
        Escribir.Escribir(INPUT_PASSWORD, RandonStrings.generarPassword());
        Click.Clickear(BOTON_SIGN_UP);
    }

    public static void registroIncompleto() throws Exception {
        Escribir.Escribir(INPUT_USERNAME, RandonStrings.generarNombre()+"@gmail.com");
        Click.Clickear(BOTON_SIGN_UP);
        EsperarTiempo.esperar(2);
    }

    public static void signUpYaRegistrados(String username,String password) throws Exception {
        Escribir.Escribir(INPUT_USERNAME, Data.get(username));
        Escribir.Escribir(INPUT_PASSWORD, Data.get(password));
        Click.Clickear(BOTON_SIGN_UP);
        EsperarTiempo.esperar(2);
    }

    public static void validarPresenciaAlerta() throws InterruptedException {
        EsperarTiempo.esperar(1);
        boolean alertaIsPresent = Alerta.alertaExiste();
        Assert.assertTrue(alertaIsPresent);
    }

    public static void validarTextAlerta(String alert) throws InterruptedException {
        EsperarTiempo.esperar(5);
        String alertaText = Data.get(alert);
        String alertaIsPresent = Alerta.alertaGetText();
        Assert.assertEquals(alertaText, alertaIsPresent,"No se pudo validar la alerta");
    }

    public static void validarRegistroExitoso() throws InterruptedException {
        Assert.assertEquals("Sign up successful.", Alerta.getText(),"No se pudo validar la alerta");
    }

    public static void validarUsuarioContraseñaIncompleto() throws InterruptedException {
        Assert.assertEquals("Please fill out Username and Password.", Alerta.getText(),"No se pudo validar la alerta");
    }

    public static void validarRegistroExistente() throws InterruptedException {
        Assert.assertEquals("This user already exist.", Alerta.getText(),"No se pudo validar la alerta");
    }

    public static void validarPasswordDebil() throws InterruptedException {
        Assert.assertEquals("Weak password. Use at least 6 characters with a mix of uppercase, lowercase, numbers, and symbols.", Alerta.getText(),"No se pudo validar la alerta");
    }

}
