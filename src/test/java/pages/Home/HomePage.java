package pages.Home;

import acciones.Click;
import acciones.Texto;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.excel.Data;

public class HomePage {
    public static final By BOTON_SIGN_UP = By.id("signin2");
    public static final By BOTON_LOG_IN = By.id("login2");
    public static final By BUTTON_WELCOME_LOGIN = By.id("nameofuser");

    public static void ClickSignUp() throws Exception {
        Click.Clickear(BOTON_SIGN_UP);
    }

    public static void ClickLogIn() throws Exception {
        Click.Clickear(BOTON_LOG_IN);
    }

    public static void ValidateLogin(String text) {
        String textoValidate = Data.get(text);
        String textoWeb = Texto.getTexto(BUTTON_WELCOME_LOGIN);
        Assert.assertEquals(textoValidate,textoWeb, "No se pudo validar el texto");
    }

    public static void ValidateLogout(String text) {
        String textoValidate = Data.get(text);
        String textoWeb = Texto.getTexto(BOTON_SIGN_UP);
        Assert.assertEquals(textoValidate,textoWeb, "No se pudo validar el texto");
    }

}
