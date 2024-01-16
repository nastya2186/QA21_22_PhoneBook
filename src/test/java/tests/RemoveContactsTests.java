package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTests extends TestBase{
    @BeforeMethod
    public void preConditions() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("liza19@gmail.com").withPassword("Maksliza1914#"));
        }

       app.getHelperContact().provideContacts();

    }

    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.getHelperContact().removeOneContacts(),1);



    }
    @Test
    public void removeAllContacts(){
        app.getHelperContact().deleteAllContacts();
        Assert.assertTrue(app.getHelperContact().getNotification().contains("No Contacts here!"));
    }
}
