package acciones;

import factory.Session;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class Click {
    public Click() {
    }

    public static void ClickearJs(By locator) throws Exception {
        clickearElemento(locator, true);
    }

    public static void Clickear(By locator) throws Exception {
        clickearElemento(locator, false);
    }

    public void hacerClickEnElementos(By locator) {
        try {
            List<WebElement> elementos = Session.getInstance().getWebDriver().findElements(locator);
            if (elementos != null && !elementos.isEmpty()) {
                Iterator var3 = elementos.iterator();

                while(var3.hasNext()) {
                    WebElement elemento = (WebElement)var3.next();
                    Acciones.hacerScroll(elemento);
                    elemento.click();
                }
            } else {
                System.out.println("La lista de elementos está vacía o es nula.");
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    private static void clickearElemento(By locator, boolean usarJs) throws Exception {
        try {
            WebElement elemento = EsperarHasta.presente(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if (ConfigReader.obtenerHabilitacionColor()) {
                    ElementoResaltado.resaltar(elemento);
                }

                if (usarJs) {
                    JavaScript.click(elemento);
                } else {
                    elemento.click();
                }

            } else {
                throw new Exception("El elemento no se encontró o no es clickeable.");
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            throw var3;
        }
    }
}
