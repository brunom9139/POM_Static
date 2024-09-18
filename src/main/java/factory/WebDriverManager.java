package factory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class WebDriverManager {
    public WebDriverManager() {
    }

    public static void initializeDriver() {
        WebDriver driver = Session.getInstance().getWebDriver();
        if (driver == null && ConfigReader.getBaseUrl() != null) {
            driver = switch (ConfigReader.getBrowser().toUpperCase()) {
                case "CHROME" -> CreatorChromeDriver.createWebDriver();
                case "FIREFOX" -> CreatorFirefoxDriver.createWebDriver();
                case "EDGE" -> CreatorEdgeDriver.createWebDriver();
                default -> new ChromeDriver();
            };

            Session.getInstance().setWebDriver(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(ConfigReader.getTimeImplicit()));
            driver.get(ConfigReader.getBaseUrl());
        }

    }

    public static WebDriver getDriver() {
        return Session.getInstance().getWebDriver();
    }

    public static void closeDriver() {
        if (Session.getInstance().getWebDriver() != null) {
            Session.getInstance().getWebDriver().close();
            Session.getInstance().getWebDriver().quit();
            Session.getInstance().removeWebDriver();
        }

    }
}
