package acciones;

import factory.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScript {
    public JavaScript() {
    }

    public static void scrollLocator(WebElement elemento) {
        ((JavascriptExecutor)WebDriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public static void click(WebElement elemento) {
        try {
            ((JavascriptExecutor)WebDriverManager.getDriver()).executeScript("arguments[0].click();", elemento);
        } catch (Exception var2) {
            var2.printStackTrace();
            throw var2;
        }
    }

    public static void limpiar(WebElement elemento) {
        try {
            ((JavascriptExecutor)WebDriverManager.getDriver()).executeScript("arguments[0].value = '';", elemento);
        } catch (Exception var2) {
            var2.printStackTrace();
            throw var2;
        }
    }

    public static void escribir(WebElement elemento, String texto) {
        try {
            ((JavascriptExecutor)WebDriverManager.getDriver()).executeScript("arguments[0].value = arguments[1];", elemento, texto);
        } catch (Exception var3) {
            var3.printStackTrace();
            throw var3;
        }
    }
}
