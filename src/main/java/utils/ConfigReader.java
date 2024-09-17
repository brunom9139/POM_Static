package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase ConfigReader proporciona métodos para leer configuraciones desde un archivo de propiedades.
 * Utiliza un archivo de propiedades para almacenar configuraciones como URL base, tiempo de espera implícito,
 * URL del servidor Selenium Grid, navegador predeterminado, y más.
 * Implementa el patrón Singleton para asegurar una única carga de las configuraciones.
 */
public class ConfigReader {
    private static final Logger logger = Logger.getLogger(ConfigReader.class.getName());
    private static final String CONFIG_FILE = "/configuration.properties";
    private static final Properties properties = new Properties();
    private static ConfigReader instance = null;

    /**
     * Constructor privado para prevenir la instanciación directa.
     */
    private ConfigReader() {
        loadProperties();
    }

    /**
     * Carga las propiedades del archivo de configuración.
     */
    private void loadProperties() {
        try (InputStream inputStream = getClass().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
                logger.log(Level.INFO, "Configuration properties loaded successfully.");
            } else {
                logger.log(Level.SEVERE, "Cannot find config file: " + CONFIG_FILE);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading config file", e);
        }
    }

    /**
     * Método para obtener la instancia única de la clase ConfigReader.
     *
     * @return instancia de ConfigReader
     */
    public static synchronized ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    /**
     * Obtiene el valor de una propiedad específica del archivo de configuración.
     *
     * @param key la clave de la propiedad
     * @return el valor de la propiedad asociada con la clave especificada, o null si no se encuentra
     */
    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.log(Level.WARNING, "No property found for key: " + key);
        }
        return value;
    }

    // Métodos estáticos para obtener configuraciones específicas usando la instancia única
    public static String getBaseUrl() {
        return getInstance().getProperty("app.baseurl");
    }

    public static String getURLSeleniumGrid() {
        return getInstance().getProperty("url.selenium.grid");
    }

    public static String getBrowser() {
        return getInstance().getProperty("app.Navegador");
    }

    public static boolean isHeadlessModeEnabled() {
        String headlessMode = getInstance().getProperty("app.headless.mode");
        return Boolean.parseBoolean(headlessMode);
    }

    public static int getTimeImplicit() {
        String value = getInstance().getProperty("app.implicitlyWait");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Invalid format for implicitlyWait, using default of 5000ms", e);
            return 5000;  // Valor por defecto
        }
    }

    public static int obtenerTiempoExplicito() {
        String value = getInstance().getProperty("app.explicitWait");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Invalid format for explicitWait, using default of 10000ms", e);
            return 10000;  // Valor por defecto
        }
    }

    public static String obtenerColorElemento() {
        return getInstance().getProperty("color.element");
    }

    public static int obtenerTiempoResaltadoElemento() {
        String value = getInstance().getProperty("color.time");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Invalid format for color time, using default of 200ms", e);
            return 200;  // Valor por defecto
        }
    }

    public static boolean obtenerHabilitacionColor() {
        String enabled = getInstance().getProperty("color.enabled");
        return Boolean.parseBoolean(enabled);
    }

    public static String obtenerBanderaDescargaExcel(){
        ConfigReader configReader = new ConfigReader();
        return configReader.getProperty("flag.download.file");
    }

    public static String obtenerUrlExcel(){
        ConfigReader configReader = new ConfigReader();
        return configReader.getProperty("remote.file");
    }

    public static String obtenerRutaDescarga(){
        ConfigReader configReader = new ConfigReader();
        return configReader.getProperty("path.file");
    }

    public static String obtenerNombreExcel(){
        ConfigReader configReader = new ConfigReader();
        return configReader.getProperty("name.file");
    }


}
