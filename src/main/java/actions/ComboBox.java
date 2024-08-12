package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

public class ComboBox {

    public static void seleccionarPorValor(By locator, String valor) throws Exception {
        seleccionarOpcion(locator, valor, TipoSeleccion.VALOR);
    }

    public static void seleccionarPorTextoVisible(By locator, String textoVisible) throws Exception {
        seleccionarOpcion(locator, textoVisible, TipoSeleccion.TEXTO_VISIBLE);
    }
    public static void seleccionarPorIndex(By locator, String index) throws Exception {
        seleccionarOpcion(locator, index, TipoSeleccion.INDEX);
    }

    private static void seleccionarOpcion(By locator, String opcion, TipoSeleccion tipo) throws Exception {
        try {
            WebElement elemento = EsperarHasta.presente(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if ("true".equalsIgnoreCase(ConfigReader.obtenerHabilitacionColor())) {
                    ElementoResaltado.resaltar(elemento);
                }
                Select select = new Select(elemento);
                switch (tipo) {
                    case VALOR:
                        select.selectByValue(opcion);
                        break;
                    case TEXTO_VISIBLE:
                        select.selectByVisibleText(opcion);
                        break;
                    case INDEX:
                        int index = Integer.parseInt(opcion);
                        select.selectByIndex(index);
                        break;
                }
            } else {
                throw new Exception("El elemento no se encontró o no es un select válido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private enum TipoSeleccion {
        VALOR, TEXTO_VISIBLE, INDEX
    }
}
