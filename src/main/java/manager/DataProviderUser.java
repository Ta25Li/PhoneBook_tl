package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"leya@bach.com", "leyaBach9!"});
        list.add(new Object[]{"green@email.com", "Green123456!"});
        list.add(new Object[]{"email@email.com", "anyPass12314!"});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginModel() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("leya@bach.com").setPassword("leyaBach9!")});
        list.add(new Object[]{new User().setEmail("green@email.com").setPassword("Green123456!")});
        list.add(new Object[]{new User().setEmail("email@email.com").setPassword("anyPass12314!")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }


}