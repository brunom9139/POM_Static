package pages.LogIn;

import acciones.Alerta;
import acciones.Click;
import acciones.Escribir;
import acciones.EsperarTiempo;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.excel.Data;

public class LogInPage {
    public static final By INPUT_USERNAME = By.id("loginusername");
    public static final By INPUT_PASSWORD = By.id("loginpassword");
    public static final By BOTON_LOG_IN_PRINCIPAL = By.id("login2");
    public static final By BOTON_LOG_IN = By.xpath("//button[@onclick='logIn()']");


    public static void LogIn(String username,String password) throws Exception {
        Escribir.Escribir(INPUT_USERNAME, Data.get(username));
        Escribir.Escribir(INPUT_PASSWORD, Data.get(password));
        Click.Clickear(BOTON_LOG_IN);
        EsperarTiempo.esperar(2);
    }

    public static void LogIn2(String username,String password) throws Exception {
        Click.Clickear(BOTON_LOG_IN_PRINCIPAL);
        Escribir.Escribir(INPUT_USERNAME, Data.get(username));
        Escribir.Escribir(INPUT_PASSWORD, Data.get(password));
        Click.Clickear(BOTON_LOG_IN);
        EsperarTiempo.esperar(2);
    }


    public static void ValidateNoLogin(String alert) {
        String dataValidate = Data.get(alert);
        String alertaIsPresent = Alerta.alertaGetText();
        Assert.assertEquals(dataValidate,alertaIsPresent);
    }

}
