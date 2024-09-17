package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CreatorFirefoxDriver {
    public CreatorFirefoxDriver() {
    }

    public static WebDriver createWebDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.addArguments(new String[]{"-private"});
        optionsFirefox.addArguments(new String[]{"--window-size=1920,1080"});
        return new FirefoxDriver(optionsFirefox);
    }
}
