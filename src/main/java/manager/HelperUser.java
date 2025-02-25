package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLogRegForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        //xPath -->> //a[text()='LOGIN']
//        loginTab.click();
    click(By.cssSelector("a[href='/login']"));
    }

    public void fillLogRegForm(String email, String password) {

        //WebElement emailInput = wd.findElement(By.name("email"));
//emailInput.click();
//emailInput.clear();
//emailInput.sendKeys(email);
        type(By.name("email"), email);

//WebElement passwordInput = wd.findElement(By.xpath("//input[last()]")); // css  -> name("password")
//passwordInput.click();
//passwordInput.clear();
//passwordInput.sendKeys(password);
        type(By.xpath("//input[last()]"), password);
    }
    public void fillLogRegForm(User user) {
type(By.name("email"), user.getEmail());
 type(By.xpath("//input[last()]"), user.getPassword());
    }

    public void submitLogin(){ //find btn Login and click
click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
     return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }


    //=========== registration ============

    public void submitReg() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
      return  wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(
                By.cssSelector(".contact-page_message__2qafk>h1")),"No Contacts here!"));
    }

    public void login(User user) {
        openLogRegForm();
        fillLogRegForm(user);
        submitLogin();

    }
}
