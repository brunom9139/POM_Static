package acciones;

import factory.WebDriverManager;
import java.util.Iterator;
import java.util.Set;

public class CambioVentana {
    private final String ventanaPrincipal = WebDriverManager.getDriver().getWindowHandle();
    private String ultimaVentana;

    public CambioVentana() {
    }

    public void cambiarVentana() {
        Set<String> ventanas = WebDriverManager.getDriver().getWindowHandles();
        Iterator var2 = ventanas.iterator();

        while(var2.hasNext()) {
            String ventana = (String)var2.next();
            if (!ventana.equals(WebDriverManager.getDriver().getWindowHandle())) {
                WebDriverManager.getDriver().switchTo().window(ventana);
                this.ultimaVentana = ventana;
                break;
            }
        }

    }

    public void volverVentanaPrincipal() {
        if (!this.ultimaVentana.isEmpty()) {
            WebDriverManager.getDriver().switchTo().window(this.ultimaVentana);
            WebDriverManager.getDriver().close();
        }

        WebDriverManager.getDriver().switchTo().window(this.ventanaPrincipal);
    }
}
