package pages.Home;

import actions.Escribir;
import org.openqa.selenium.By;
import utils.excel.Data;

public class HomePage {
    public static final By BOTON_REALIZAR_UN_PAGO_MANUAL = By.id("userName");

    public static void prueba(String hola) throws Exception {
        Escribir.Escribir(BOTON_REALIZAR_UN_PAGO_MANUAL,Data.get(hola));
    }

}
