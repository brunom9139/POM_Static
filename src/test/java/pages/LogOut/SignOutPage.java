package pages.LogOut;

import acciones.Click;
import org.openqa.selenium.By;

public class SignOutPage {
    public static final By BUTTON_LOG_OUT = By.id("logout2");

    public static void ClickLogOut() throws Exception {
        Click.Clickear(BUTTON_LOG_OUT);
    }

}
