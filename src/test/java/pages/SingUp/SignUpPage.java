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

    public static void signUpYaRegistrados(String username,String password) throws Exception {
        Escribir.Escribir(INPUT_USERNAME, Data.get(username));
        Escribir.Escribir(INPUT_PASSWORD, Data.get(password));
        Click.Clickear(BOTON_SIGN_UP);
        EsperarTiempo.esperar(2);
    }

    public static void validarPresenciaAlerta(){
        boolean alertaIsPresent = Alerta.alertaExiste();
        Assert.assertTrue(alertaIsPresent);
    }

    public static void validarTextAlerta(String alert) {
        String alertaText = Data.get(alert);
        String alertaIsPresent = Alerta.alertaGetText();
        Assert.assertEquals(alertaText, alertaIsPresent,"No se pudo validar la alerta");
    }
}
