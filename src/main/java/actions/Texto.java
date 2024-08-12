package actions;

import factory.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class Texto {
    public static boolean compararTexto(By locator, String texto) {
        try {
            WebElement elemento = WebDriverManager.getDriver().findElement(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if ("true".equalsIgnoreCase(ConfigReader.obtenerHabilitacionColor())) {
                    ElementoResaltado.resaltar(elemento);
                }
                String textoElemento = elemento.getText().trim();
                return textoElemento.equals(texto.trim());
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
