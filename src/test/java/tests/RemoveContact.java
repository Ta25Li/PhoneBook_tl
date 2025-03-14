package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{

    @BeforeMethod (alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .setEmail("leya@bach.com").setPassword("leyaBach9!"));
        }
     app.getHelperContact().provideContacts();         //if list of contact <3 -- add 3 contacts

    }

    @Test (groups = {"smoke"})
    public void removeFirstContact(){
        //Assert size contactList less by 1
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);

    }

    @Test
    public void removeAllContacts(){
        //"No contacts here"
        app.getHelperContact().removeAllContacts();

        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());
    }
}
