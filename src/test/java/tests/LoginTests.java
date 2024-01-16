package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @BeforeMethod
    public void preConditions(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Logout is finished");
        }

    }

    @Test
    public void loginSuccess(){
        logger.info("Start test with name `loginSuccess`");
        logger.info("Test data --->email: `liza19@gmail.com` & password: `Maksliza1914#`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19@gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign Out' present");



    }

    @Test
    public void loginSuccessModel(){
        logger.info("Test data --->email: `liza19@gmail.com` & password: `Maksliza1914#`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19@gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();


        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign Out' present");



    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data --->email: `liza19gmail.com` & password: `Maksliza1914#`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text:`Wrong email or password`");

    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data --->email: `liza19@gmail.com` & password: `Maksliza1914`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza19@gmail.com", "Maksliza1914");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text:`Wrong email or password`");


    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --->email: `liza9@gmail.com` & password: `Maksliza1914#`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("liza9@gmail.com", "Maksliza1914#");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text:`Wrong email or password`");


    }


}
