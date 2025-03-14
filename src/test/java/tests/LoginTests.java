package tests;
//leya@bach.com
//leyaBach9!

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {

    @BeforeMethod (alwaysRun = true)
    public void preCondition(){
        //if SignOut present --> logout
        if (app.getHelperUser().isLogged()) // if is logged true - then do log out
            app.getHelperUser().logout();

        logger.info("Before method - logout performed");


    }
    @Test
    public void loginSuccess() {
        logger.info("Start - name 'loginSuccess'");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach9!");
       logger.info("Test data---> email: 'leya@bach.com' & password: 'leyaBach9!'");
        app.getHelperUser().submitLogin();

        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());

        logger.info("Assert check is element button 'Sign out' present");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Test (groups = {"smoke"})
    public void loginSuccess1 (){
        User user = new User().setEmail("leya@bach.com").setPassword("leyaBach9!");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    //================= d a t a    p r o v i d e r =====================================



    @Test(dataProvider = "loginData",dataProviderClass = DataProviderUser.class) // takes data from data provider
    public void loginSuccessData(String email, String password) {
        logger.info("Start - name 'loginSuccessData'");

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(email, password);
        logger.info("Data provider ---> email: "+ email + " & password: " + password);
        app.getHelperUser().submitLogin();
  Assert.assertTrue(app.getHelperUser().isLogged());

        logger.info("Assert check is element button 'Sign out' present");


    }


    @Test (dataProvider =  "loginModel", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data --->"+ user.toString());

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test (dataProvider =  "loginFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDP(User user) {
        logger.info("Test data --->"+ user.toString());

        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }



  //  =============================== Negative =================
    @Test (groups = {"smoke"})
    public void loginWrongEmail(){
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leyabach.com", "leyaBach9!");
        logger.info("Test data---> email: 'leyabach.com' & password: 'leyaBach9!'");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginWrongPass(){
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach!");
        logger.info("Test data---> email: 'leya@bach.com' & password: 'leyaBach!'");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginUnregedUser(){
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("unreg@bach.com", "leyaBach9!");
        logger.info("Test data---> email: 'unreg@bach.com' & password: 'leyaBach9!'");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }




}
