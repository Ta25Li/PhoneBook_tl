package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ConcurrentModificationException;

public class AddNewContact extends TestBase {

    @BeforeClass
    public void preCondition() { // login 1 time to perform all the test
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .setEmail("leya@bach.com").setPassword("leyaBach9!"));
        }
    }

    @Test (dataProvider = "contactSuccess",dataProviderClass = DataProviderContact.class)
    public void addContactSuccessAllFields(Contact contact) {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

//        Contact contact = Contact.builder()
//                .name("Axl" + i)
//                .lastName("Mclane")
//                .phone("1234567" + i)
//                .email("email" + i + "@email.com")
//                .address("San Fransisco, Green str 1")
//                .description("all fields")
//
//                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //   app.getHelperContact().pause(5000);
        app.getHelperContact().getScreen
                ("src/test/screenshots/screen-" + i +".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addContactSuccessReq() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("Jao__Req_Fields" + i)
                .lastName("Mclane")
                .phone("654321" + i)
                .email("email" + i + "@email.com")
                .address("San Fransisco, Green str 1")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //  app.getHelperContact().pause(5000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }
    //================ negative =============================


    @Test
    public void wrongName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Mclane")
                .phone("65432112234")
                .email("email@email.com")
                .address("San Fransisco, Green str 1")
                .description("wrong name")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //   app.getHelperContact().pause(5000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void wrongLastName() {
        Contact contact = Contact.builder()
                .name("Jao")
                .lastName("")
                .phone("65432112234")
                .email("email@email.com")
                .address("San Fransisco, Green str 1")
                .description("wrong last name")

                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //   app.getHelperContact().pause(5000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void wrongAddress() {
        Contact contact = Contact.builder()
                .name("Jason")
                .lastName("Mclane")
                .phone("65432112234")
                .email("email@email.com")
                .address("")
                .description("wrong address")


                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //   app.getHelperContact().pause(5000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test (dataProvider = "contactWrongPhone",dataProviderClass = DataProviderContact.class)
    public void wrongPhone(Contact contact) {
//        Contact contact = Contact.builder()
//                .name("Jane")
//                .lastName("Mclane")
//                .phone("")
//                .email("email@email.com")
//                .address("San Fransisco, Green str 1")
//                .description("wrong phone")
//
//                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //   app.getHelperContact().pause(5000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: "));
    }

    @Test
    public void wrongEmail() {
        Contact contact = Contact.builder()
                .name("Max")
                .lastName("Mclane")
                .phone("65432112234")
                .email("emailemail.com")
                .address("San Fransisco, Green str 1")
                .description("wrong email")


                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //   app.getHelperContact().pause(5000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid:"));
    }
}
