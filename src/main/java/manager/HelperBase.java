package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();  // clear field to make sure it's empty
       clearNew(element);
        if (text != null) {
            element.sendKeys(text);
        }
    }
    public void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }

    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;

    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertPresent(String message) {
        //click ok in Alert --> alert.accept();
        //click cancel --> alert.dismiss();
        // type into alert --> alert.sendKeys("hello");
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        if (alert != null && alert.getText().contains(message)){  //если надо точное совпадение текска
            // алерта то   .equals(message)
            pause(5000);
            alert.accept();
            return true;
        }
        return false;
    }



}
