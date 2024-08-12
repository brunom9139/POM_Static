package actions;

import factory.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BuscarElemento {
    public static WebElement buscarElemento(By locator){
        try {
            return WebDriverManager.getDriver().findElement(locator);
        }catch (NoSuchElementException e){
            throw new ElementoNoEncontradoException(STR."Elemento no encontrado: \{locator.toString()}", e);
        }
    }
}
