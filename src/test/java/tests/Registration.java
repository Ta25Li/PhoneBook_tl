package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class Registration extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        User user = new User()
                .setEmail("green" + i + "@email.com")
                .setPassword("Green123456!");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }
//=============== negative ====================
    @Test
    //@Test (description = "Bug report 12345",enabled=false)   <---- to make method invisible while
    // waiting for bug resolution

    public void regWrongEmail() {

        User user = new User()
                .setEmail("greenemail.com")
                .setPassword("Green123456!");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void regWrongPassword() {

        User user = new User()
                .setEmail("green@email.com")
                .setPassword("Green!");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void regEmptyEmail() {

        User user = new User()
                .setEmail("")
                .setPassword("Green!");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }
    @Test
    public void regEmptyPassword() {

        User user = new User()
                .setEmail("green@email.com")
                .setPassword("");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test
    public void regExistingUser() {

        User user = new User()
                .setEmail("green@email.com")
                .setPassword("Green123456!");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }
}
