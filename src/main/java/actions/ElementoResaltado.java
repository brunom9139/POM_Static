package actions;

import factory.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class ElementoResaltado {
    public static void resaltar(WebElement elemento) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
        js.executeScript("arguments[0].style.border='2px solid " + ConfigReader.obtenerColorElemento() + "'", elemento);
        try {
            Thread.sleep(ConfigReader.obtenerTiempoResaltadoElemento());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].style.border=''", elemento);
    }
}
