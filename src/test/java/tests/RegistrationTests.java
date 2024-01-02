package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
@Test
    public void registrationSuccess(){
       Random random = new Random();
       int i = random.nextInt(1000);
//        int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User().withEmail("maks"+i+"@gmail.com").withPassword("Maks04062019#");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
    Assert.assertTrue(app.getHelperUser().isLogged());
    Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }
@Test
    public void registrationWrongEmail(){

        User user = new User().withEmail("maksgmail.com").withPassword("Maks04062019");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }

    @Test
    public void registrationWrongPassword(){
        Random random = new Random();
        int i = random.nextInt(1000);

        User user = new User().withEmail("maks"+i+"@gmail.com").withPassword("Maks04");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }

    @Test
    public void registrationExistUser(){

        User user = new User().withEmail("maks@gmail.com").withPassword("Maks049987#");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }




}
