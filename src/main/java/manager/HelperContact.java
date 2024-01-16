package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }



    public void openAddContactForm(){
        pause(500);
        click(By.xpath("//*[text()='ADD']"));
    }



    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void save() {
        click(By.xpath("//*[text()='Save']"));
    }


    public boolean isContactAddedByName(String name) {
        List<WebElement>list = wd.findElements(By.cssSelector("h2"));
        for(WebElement el:list){
            if(el.getText().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement>list = wd.findElements(By.cssSelector("h3"));
        for(WebElement el:list){
            if(el.getText().equals(phone)){
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }


    public void deleteAllContacts() {
        List<WebElement>list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));

        for(WebElement el:list){

            pause(1500);
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//*[text()='Remove']"));


        }
    }


    public void deleteOneContacts() {


        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//*[text()='Remove']"));
        pause(1500);


    }





    public void provideContacts() {
        int i = (int)(System.currentTimeMillis()/1000%3600);
        List<WebElement>list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
            if(list.size()<3){
            openAddContactForm();
            fillContactForm(Contact.builder()
                    .name("Liza")
                    .lastName("Kim")
                    .phone("0587285"+i)
                    .email("Nasty"+i+"@gmail.com")
                    .address("Silver 10")
                    .description("second number 054898884")
                    .build());
            save();


        }
    }


    public int removeOneContacts() {
        int before = countOfContacts();
        logger.info("Number of contacts before remove is --->"+before);
deleteOneContacts();
        int after = countOfContacts();
        logger.info("Number of contacts after remove is --->"+after);
        return before-after;
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }
}
