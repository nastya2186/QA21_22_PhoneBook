package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTests extends TestBase{
    @BeforeMethod
    public void preConditions() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("liza19@gmail.com").withPassword("Maksliza1914#"));
        }
//        app.getHelperContact().provideContacts();
    }

    @Test
    public void removeFirstContact(){

    }
    @Test
    public void removeAllContacts(){


    }
}
