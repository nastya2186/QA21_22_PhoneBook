package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19@gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());



    }
}
