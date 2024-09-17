package acciones;

import factory.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class Alerta {
    public Alerta() {
    }

    public static boolean alertaExiste() {
        try {
            Alert alerta = WebDriverManager.getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException var1) {
            return false;
        }
    }

    public static String alertaGetText() {
        try {
            Alert alerta = WebDriverManager.getDriver().switchTo().alert();
            return alerta.getText();
        } catch (NoAlertPresentException var1) {
            return "No hay alerta presente";
        }
    }
}
