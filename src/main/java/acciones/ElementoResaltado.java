package acciones;

import factory.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class ElementoResaltado {
    public ElementoResaltado() {
    }

    public static void resaltar(WebElement elemento) {
        JavascriptExecutor js = (JavascriptExecutor)WebDriverManager.getDriver();
        js.executeScript("arguments[0].style.border='2px solid " + ConfigReader.obtenerColorElemento() + "'", elemento);

        try {
            Thread.sleep((long)ConfigReader.obtenerTiempoResaltadoElemento());
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        js.executeScript("arguments[0].style.border=''", elemento);
    }
}
