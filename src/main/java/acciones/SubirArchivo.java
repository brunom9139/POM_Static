package acciones;

import factory.WebDriverManager;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class SubirArchivo {
    public SubirArchivo() {
    }

    public static void subir(By locator, File archivo) throws Exception {
        try {
            WebElement elemento = WebDriverManager.getDriver().findElement(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if (ConfigReader.obtenerHabilitacionColor()) {
                    ElementoResaltado.resaltar(elemento);
                }

                elemento.sendKeys(new CharSequence[]{archivo.getAbsolutePath()});
            }

        } catch (Exception var3) {
            var3.printStackTrace();
            throw new Exception("No se pudo subir el archivo.");
        }
    }
}
