package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;

    HelperContact helperContact;

    public void init(){
        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("All tests run in Chrome Browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://telranedu.web.app/");
        logger.info("The link---"+ wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        helperContact = new HelperContact(wd);


    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    public void stop(){
        wd.quit();

    }
}
