package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.excel.Data;

import java.io.IOException;

@Test
@CucumberOptions(
        features = "src/test/java/features",//donde estara lo que se debe ejecutar
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        glue = "steps",//indica donde encontrar las pasos con los metodos, asociadoas a los pasos de los escenarios
        tags = "@11"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void DownloadFileFeatures() throws IOException {
        //Data.downloadFile();
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}