package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void preConditions(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }

    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19@gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());



    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19@gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());



    }


}
