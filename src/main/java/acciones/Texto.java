package acciones;

import factory.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class Texto {
    public Texto() {
    }

    public static boolean compararTexto(By locator, String texto) {
        try {
            WebElement elemento = WebDriverManager.getDriver().findElement(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if (ConfigReader.obtenerHabilitacionColor()) {
                    ElementoResaltado.resaltar(elemento);
                }

                String textoElemento = elemento.getText().trim();
                return textoElemento.equals(texto.trim());
            } else {
                return false;
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            throw var4;
        }
    }

    public static String getTexto(By locator) {
        try {
            WebElement elemento = WebDriverManager.getDriver().findElement(locator);
            return elemento.getText();
        } catch (Exception var2) {
            var2.printStackTrace();
            throw var2;
        }
    }
}
