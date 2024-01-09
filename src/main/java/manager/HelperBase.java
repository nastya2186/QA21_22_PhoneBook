package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class HelperBase {

    WebDriver wd;



    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text != null) {
            System.out.println("hello");
            element.sendKeys(text);
        }


    }


    public void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }

    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();

    }

    public boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size() >0;
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert !=null && alert.getText().contains(message)) {
            //click ok
            System.out.println(alert.getText());
            alert.accept();
            //click cancel ---> alert.dismiss();
            //type into alert ---> alert.sendKeys();
            return true;
        }
        return false;
    }


    public String getMessage() {
        return wd.findElement(By.cssSelector(".contact-item_card__2SOIM>h3")).getText();
    }
    public String getNotification() {
        return wd.findElement(By.cssSelector(".contact-page_message__2qafk")).getText();
    }


    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
       File tmp =  takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}


