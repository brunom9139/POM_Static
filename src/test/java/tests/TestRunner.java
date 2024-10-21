package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/java/features", //donde estara lo que se debe ejecutar
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", //este genera el reporte en allure
                "pretty",
                "html:target/cucumber-reports.html", // Reporte HTML
                "json:target/cucumber.json" // Añadimos la generación del archivo cucumber.json
        },
        glue = "steps", //indica donde encontrar los pasos asociados a los escenarios
        tags = ""
)
//mvn clean test -X
//mvn clean test -D"cucumber.filter.tags=@TEST_1001"
public class TestRunner extends AbstractTestNGCucumberTests {


    @BeforeSuite
    public void setupTags() {
        // Obtener el tag desde las propiedades del sistema
        String tag = System.getProperty("cucumber.filter.tags", "@TEST"); // Valor por defecto
        // Ajustar el valor de 'tags' en tiempo de ejecución
        System.setProperty("cucumber.filter.tags", tag);
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
