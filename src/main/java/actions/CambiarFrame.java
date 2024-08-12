package actions;

import factory.WebDriverManager;
import org.openqa.selenium.By;

public class CambiarFrame {
    public void cambiarAFramePorId(String id) {
        WebDriverManager.getDriver().switchTo().frame(id);
    }

    public void cambiarAFramePorNombre(String nombre) {
        WebDriverManager.getDriver().switchTo().frame(nombre);
    }

    public void cambiarAFramePorElemento(By locator) {
        WebDriverManager.getDriver().switchTo().frame(WebDriverManager.getDriver().findElement(locator));
    }

    public void volverAlContenidoPrincipal() {
        WebDriverManager.getDriver().switchTo().defaultContent();
    }
}
