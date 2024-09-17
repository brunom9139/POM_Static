package steps.LogOut;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import pages.Home.HomePage;
import pages.LogOut.SignOutPage;

public class LogOutSteps {
    @Cuando("Desea desloguearse")
    public void deseaDesloguearse() throws Exception {
        SignOutPage.ClickLogOut();
    }

    @Entonces("Se deloguea correctamente")
    public void seDelogueaCorrectamente() {
    }

    @Entonces("Se deloguea correctamente {string}")
    public void seDelogueaCorrectamente(String login) throws Exception {
        HomePage.ValidateLogout(login);
    }
}
