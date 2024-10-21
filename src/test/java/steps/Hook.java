package steps;

import factory.Session;
import factory.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.excel.Data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class Hook {

    @Before(order = 0)
    public synchronized void antes(Scenario scenario) throws IOException {
        if (WebDriverManager.getDriver() == null) {
            WebDriverManager.initializeDriver();
            Data.setearTagsExcel((List<String>) scenario.getSourceTagNames());
        }
    }

    @After(order = 0)
    public synchronized void despues(Scenario scenario) {
        try {
            Allure.addAttachment(
                    scenario.getName(),
                    new ByteArrayInputStream(((TakesScreenshot) Session.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES))
            );

            //Esto es para generar una un reporte
            //byte [] screenshot = ((TakesScreenshot) Session.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES);
            //scenario.attach(screenshot,"image/png",scenario.getName());

            WebDriverManager.closeDriver();
        } catch (Exception e) {
            WebDriverManager.closeDriver();
        }
    }


    public static void captura() {
        try {
            Allure.addAttachment(
                    "Captura de pantalla",
                    new ByteArrayInputStream(((TakesScreenshot) Session.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
