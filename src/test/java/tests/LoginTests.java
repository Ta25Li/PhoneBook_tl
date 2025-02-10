package tests;
//leya@bach.com
//leyaBach9!

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SignOut present --> logout
        if (app.getHelperUser().isLogged()) // if is logged true - then do log out
            app.getHelperUser().logout();


    }
    @Test
    public void loginSuccess() {
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach9!");
        app.getHelperUser().submitLogin();

        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach9!");
        app.getHelperUser().submitLogin();

     Assert.assertTrue(app.getHelperUser().isLogged());
    }
  //  =============================== Negative =================
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leyabach.com", "leyaBach9!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
    @Test
    public void loginWrongPass(){
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
    @Test
    public void loginUnregedUser(){
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("unreg@bach.com", "leyaBach9!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }




}
