package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class Escribir {
    public static void Escribir(By locator, String texto) throws Exception {
        escribirTexto(locator,texto, false);
    }

    public static void EscribirJs(By locator, String texto) throws Exception {
        escribirTexto(locator,texto, true);
    }

    public static void escribirTexto(By locator, String texto, boolean usarJs) {
        try {
            WebElement elemento = EsperarHasta.presente(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if ("true".equalsIgnoreCase(ConfigReader.obtenerHabilitacionColor())) {
                    ElementoResaltado.resaltar(elemento);
                }
                if (usarJs) {
                    JavaScript.limpiar(elemento);
                    JavaScript.escribir(elemento,texto);
                } else {
                    elemento.clear();
                    elemento.sendKeys(texto);
                }
            } else {
                System.out.println("El elemento no se encontró o no es escribible.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
