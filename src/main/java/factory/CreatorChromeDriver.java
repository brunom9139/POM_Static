package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

public class CreatorChromeDriver {
    public static WebDriver createWebDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        optionsChrome.addArguments("--disable-extensions");
        if (ConfigReader.isHeadlessModeEnabled()) {
            optionsChrome.addArguments("--headless");
        }
        return new ChromeDriver(optionsChrome);
    }
}
