package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CreatorFirefoxDriver {
    public static WebDriver createWebDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.addArguments("-private");
        optionsFirefox.addArguments("--window-size=1920,1080");
        return new FirefoxDriver(optionsFirefox);
    }
}
