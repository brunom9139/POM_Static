package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.logging.Level;

import static utils.ConfigReader.logger;

public class WebDriverManager {

    public static void initializeDriver() {
        WebDriver driver = Session.getInstance().getWebDriver();
        if (driver == null && ConfigReader.getBaseUrl() != null) {
            switch (ConfigReader.getBrowser().toUpperCase()) {
                case "CHROME":
                    driver = CreatorChromeDriver.createWebDriver();
                    break;
                case "FIREFOX":
                    driver = CreatorFirefoxDriver.createWebDriver();
                    break;
                case "EDGE":
                    driver = CreatorEdgeDriver.createWebDriver();
                    break;
                default:
                    logger.log(Level.WARNING, "Navegador no válido. Se utilizará Chrome por defecto.");
                    driver = new ChromeDriver();
            }
            Session.getInstance().setWebDriver(driver);//setDriver guarda la instancia de WebDriver en el contexto actual de la session, para que en la ejecucion no se pierda el hilo
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(ConfigReader.getTimeImplicit()));
            driver.get(ConfigReader.getBaseUrl());
        } else {
            logger.log(Level.SEVERE, "Base URL is null. WebDriver cannot be initialized.");
        }
    }

    public static WebDriver getDriver() {
        return Session.getInstance().getWebDriver();
    }

    public static void closeDriver(){
        if (Session.getInstance().getWebDriver() != null) {
            Session.getInstance().getWebDriver().close();
            Session.getInstance().getWebDriver().quit();
            Session.getInstance().removeWebDriver();
        }
    }
}
