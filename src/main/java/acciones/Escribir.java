package acciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class Escribir {
    public Escribir() {
    }

    public static void Escribir(By locator, String texto) throws Exception {
        escribirTexto(locator, texto, false);
    }

    public static void EscribirJs(By locator, String texto) throws Exception {
        escribirTexto(locator, texto, true);
    }

    public static void escribirTexto(By locator, String texto, boolean usarJs) {
        try {
            WebElement elemento = EsperarHasta.presente(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if (ConfigReader.obtenerHabilitacionColor()) {
                    ElementoResaltado.resaltar(elemento);
                }

                if (usarJs) {
                    JavaScript.limpiar(elemento);
                    JavaScript.escribir(elemento, texto);
                } else {
                    elemento.clear();
                    elemento.sendKeys(new CharSequence[]{texto});
                }
            } else {
                System.out.println("El elemento no se encontró o no es escribible.");
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}
