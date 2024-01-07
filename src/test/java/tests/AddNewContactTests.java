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
    int i = (int)(System.currentTimeMillis()/1000%3600);
    Contact contact = Contact.builder()
            .name("Liza")
            .lastName("Kim")
            .phone("0587285"+i)
            .email("Nasty"+i+"@gmail.com")
            .address("Silver 10")
            .description("second number 054898884")
            .build();
    app.getHelperContact().openAddContactForm();
    app.getHelperContact().fillContactForm(contact);
    app.getHelperContact().save();
    Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
    Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    //Assert.assertEquals(app.getHelperContact().getMessage(), contact.getPhone());

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
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));


    }


    @Test
    public void addNewContactWrongName(){
        Contact contact = Contact.builder()
                .name(" ")
                .lastName("Kim")
                .phone("0587285657")
                .email("Nastya@gmail.com")
                .address("Silver 10")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().save();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());



    }

    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Liza")
                .lastName("Kim")
                .phone("0587285657")
                .email("nast22@gmail.com")
                .address(" ")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().save();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name(" ")
                .lastName("Kim")
                .phone("0587285657")
                .email("Nastya@gmail.com")
                .address("Silver 10")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().save();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

      //  Assert.assertTrue(app.getHelperContact().isSaveButtonNotActive());

    }

    @Test
    public void addNewContactWrongPhone(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("Liza")
                .lastName("Kim")
                .phone("05"+i)
                .email("Nasty"+i+"@gmail.com")
                .address("Silver 10")
                .description("second number 054898884")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().save();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone not valid: Phone number must contain " +
                "only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("Liza")
                .lastName("Kim")
                .phone("0587285"+i)
                .email("Nasty"+i+"gmail.com")
                .address("Silver 10")
                .description("second number 054898884")
                .build();
        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().save();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));

    }

}
