package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;

public class CreatorEdgeDriver {
    public CreatorEdgeDriver() {
    }

    public static WebDriver createWebDriver() {
        EdgeOptions optionsEdge = new EdgeOptions();
        optionsEdge.addArguments(new String[]{"--start-maximized"});
        optionsEdge.addArguments(new String[]{"--disable-extensions"});
        if (ConfigReader.isHeadlessModeEnabled()) {
            optionsEdge.addArguments(new String[]{"--headless"});
        }

        return new EdgeDriver(optionsEdge);
    }
}
