package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

public class CreatorChromeDriver {
    public CreatorChromeDriver() {
    }

    public static WebDriver createWebDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments(new String[]{"--start-maximized"});
        optionsChrome.addArguments(new String[]{"--disable-extensions"});
        if (ConfigReader.isHeadlessModeEnabled()) {
            optionsChrome.addArguments(new String[]{"--headless"});
        }

        return new ChromeDriver(optionsChrome);
    }
}
