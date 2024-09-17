package acciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

public class ComboBox {
    public ComboBox() {
    }

    public static void seleccionarPorValor(By locator, String valor) throws Exception {
        seleccionarOpcion(locator, valor, ComboBox.TipoSeleccion.VALOR);
    }

    public static void seleccionarPorTextoVisible(By locator, String textoVisible) throws Exception {
        seleccionarOpcion(locator, textoVisible, ComboBox.TipoSeleccion.TEXTO_VISIBLE);
    }

    public static void seleccionarPorIndex(By locator, String index) throws Exception {
        seleccionarOpcion(locator, index, ComboBox.TipoSeleccion.INDEX);
    }

    private static void seleccionarOpcion(By locator, String opcion, TipoSeleccion tipo) throws Exception {
        try {
            WebElement elemento = EsperarHasta.presente(locator);
            if (elemento != null) {
                JavaScript.scrollLocator(elemento);
                if (ConfigReader.obtenerHabilitacionColor()) {
                    ElementoResaltado.resaltar(elemento);
                }

                Select select = new Select(elemento);
                switch (tipo.ordinal()) {
                    case 0:
                        select.selectByValue(opcion);
                        break;
                    case 1:
                        select.selectByVisibleText(opcion);
                        break;
                    case 2:
                        int index = Integer.parseInt(opcion);
                        select.selectByIndex(index);
                }

            } else {
                throw new Exception("El elemento no se encontró o no es un select válido.");
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            throw var6;
        }
    }

    private static enum TipoSeleccion {
        VALOR,
        TEXTO_VISIBLE,
        INDEX;

        private TipoSeleccion() {
        }
    }
}
