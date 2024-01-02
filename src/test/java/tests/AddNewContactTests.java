package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

@BeforeClass
public void preConditions(){
if(!app.getHelperUser().isLogged()){
    app.getHelperUser().login(new User().withEmail("liza19@gmail.com").withPassword("Maksliza1914#"));
}
}

@Test
    public void addNewContactSuccess(){
    Contact contact = Contact.builder()
            .name("Vika")
            .lastName("Kim")
            .phone("0587285656")
            .email("Nastya@gmail.com")
            .address("Silver 10")
            .description("second number 054898884")
            .build();
    app.getHelperContact().openAddContactForm();
    app.getHelperContact().fillContactForm(contact);
    app.getHelperContact().save();
   // Assert.assertEquals(app.getHelperUser().getMessage(), "Vika");

}

    @Test
    public void addNewContactReqSuccess(){
        Contact contact = Contact.builder()
                .name("Liza")
                .lastName("Kim")
                .phone("0587285657")
                .email("Nastya@gmail.com")
                .address("Silver 10")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().save();
       // Assert.assertEquals(app.getHelperUser().getMessage(), "Liza");

    }

}
