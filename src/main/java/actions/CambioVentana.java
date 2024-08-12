package actions;

import factory.WebDriverManager;

import java.util.Set;

public class CambioVentana {
    private final String ventanaPrincipal = WebDriverManager.getDriver().getWindowHandle(); // Variable para almacenar la ventana principal
    private String ultimaVentana; // Variable para almacenar la última ventana

    /*public CambioVentana(){
        ventanaPrincipal = WebDriverManager.getDriver().getWindowHandle(); // Inicialización fuera de los métodos
    }*/

    public void cambiarVentana(){
        Set<String> ventanas = WebDriverManager.getDriver().getWindowHandles();
        for(String ventana : ventanas) {
            if(!ventana.equals(WebDriverManager.getDriver().getWindowHandle())) {
                WebDriverManager.getDriver().switchTo().window(ventana);
                ultimaVentana = ventana; // Actualiza la última ventana
                break;
            }
        }
    }

    public void volverVentanaPrincipal(){
        if (!ultimaVentana.isEmpty()) {
            WebDriverManager.getDriver().switchTo().window(ultimaVentana); // Cambia a la última ventana
            WebDriverManager.getDriver().close(); // Cierra la última ventana
        }
        WebDriverManager.getDriver().switchTo().window(ventanaPrincipal); // Cambia a la ventana principal
    }
}
