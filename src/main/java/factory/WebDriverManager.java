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
            //Object driver;
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
                    driver = new ChromeDriver();
            }

            Session.getInstance().setWebDriver((WebDriver)driver);
            ((WebDriver)driver).manage().timeouts().implicitlyWait(Duration.ofMillis((long)ConfigReader.getTimeImplicit()));
            ((WebDriver)driver).get(ConfigReader.getBaseUrl());
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
