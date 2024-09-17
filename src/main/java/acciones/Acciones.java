package acciones;

import factory.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Acciones {
    public Acciones() {
    }

    public static void hacerClick(By locator) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        scrollElemento(locator, actions).click().perform();
    }

    private static Actions scrollElemento(By locator, Actions actions) {
        return actions.moveToElement(BuscarElemento.buscarElemento(locator));
    }

    public static void hacerScroll(By locator) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(BuscarElemento.buscarElemento(locator)).perform();
    }

    public static void hacerScroll(WebElement elemento) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(elemento).perform();
    }

    public static void hacerClickSecundario(By locator) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.contextClick(BuscarElemento.buscarElemento(locator)).perform();
    }

    public static void clickEscribirFlechaAbajoEnter(By locator, String text) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.click(BuscarElemento.buscarElemento(locator)).sendKeys(new CharSequence[]{text}).sendKeys(new CharSequence[]{Keys.ARROW_DOWN}).sendKeys(new CharSequence[]{Keys.ENTER}).perform();
    }

    public static void hacerDobleClick(By locator) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.doubleClick(BuscarElemento.buscarElemento(locator)).perform();
    }

    public static void arrastrarSoltar(By fuente, By destino) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        WebElement archivoFuente = BuscarElemento.buscarElemento(fuente);
        WebElement archivoDestino = BuscarElemento.buscarElemento(destino);
        actions.dragAndDrop(archivoFuente, archivoDestino).perform();
    }

    public static void arrastrarSoltar(WebElement fuente, WebElement destino) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.dragAndDrop(fuente, destino).perform();
    }

    public void control_A(By locator) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(BuscarElemento.buscarElemento(locator)).keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.CONTROL).perform();
    }

    public static void realizarAccionConTeclas(By locator, Keys keyModifier, CharSequence keyToSend) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        WebElement elemento = BuscarElemento.buscarElemento(locator);
        actions.moveToElement(elemento);
        actions.keyDown(keyModifier);
        actions.sendKeys(new CharSequence[]{keyToSend});
        actions.keyUp(keyModifier);
        actions.perform();
    }

    public static void borrarTexto(By locator) {
        Actions actions = new Actions(WebDriverManager.getDriver());
        actions.moveToElement(BuscarElemento.buscarElemento(locator)).sendKeys(new CharSequence[]{Keys.DELETE}).perform();
    }
}
