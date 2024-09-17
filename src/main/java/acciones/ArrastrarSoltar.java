package acciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

public class ArrastrarSoltar {
    public ArrastrarSoltar() {
    }

    public static void arrastrarYSoltar(By elementoOrigen, By elementoDestino) throws Exception {
        try {
            WebElement fuente = EsperarHasta.presente(elementoOrigen);
            WebElement destino = EsperarHasta.presente(elementoDestino);
            if (fuente != null && destino != null) {
                JavaScript.scrollLocator(fuente);
                if (ConfigReader.obtenerHabilitacionColor()) {
                    ElementoResaltado.resaltar(fuente);
                    ElementoResaltado.resaltar(destino);
                }

                Acciones.arrastrarSoltar(fuente, destino);
            }

        } catch (Exception var4) {
            var4.printStackTrace();
            throw var4;
        }
    }

}
