package actions;

import factory.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

import java.io.File;

public class SubirArchivo {

    public static void subir(By locator, File archivo) throws Exception {
        try {
            WebElement elemento = WebDriverManager.getDriver().findElement(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if ("true".equalsIgnoreCase(ConfigReader.obtenerHabilitacionColor())) {
                    ElementoResaltado.resaltar(elemento);
                }
                elemento.sendKeys(archivo.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo subir el archivo.");
        }
    }
}
