package acciones;

import factory.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

public class EsperarHasta {
    public EsperarHasta() {
    }

    public static WebElement presente(By locator) {
        WebElement elemento = null;
        Duration duracion = Duration.ofMillis((long)ConfigReader.obtenerTiempoExplicito());

        try {
            WebDriverWait esperar = new WebDriverWait(WebDriverManager.getDriver(), duracion);
            esperar.until(ExpectedConditions.and(new ExpectedCondition[]{ExpectedConditions.presenceOfElementLocated(locator), ExpectedConditions.visibilityOfElementLocated(locator), ExpectedConditions.elementToBeClickable(locator)}));
            elemento = WebDriverManager.getDriver().findElement(locator);
        } catch (TimeoutException var4) {
            System.out.println("Tiempo de espera agotado para el elemento con locator: " + locator.toString());
        }

        return elemento;
    }
}
