package acciones;

import factory.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BuscarElemento {
    public BuscarElemento() {
    }

    public static WebElement buscarElemento(By locator) {
        try {
            return WebDriverManager.getDriver().findElement(locator);
        } catch (NoSuchElementException var2) {
            throw new ElementoNoEncontradoException("Elemento no encontrado: " + locator.toString(), var2);
        }
    }
}
