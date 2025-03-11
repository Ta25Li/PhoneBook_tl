package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
list.add(new Object[]{Contact.builder()
        .name("Jao_fields" )
        .lastName("Mclane")
        .phone("6543211263" )
        .email("email@email.com")
        .address("San Fransisco, Green str 1")
        .description("all fields")
        .build()

});
        list.add(new Object[]{Contact.builder()
                .name("JaoReqFields" )
                .lastName("Mclane")
                .phone("6543211233" )
                .email("email1@email.com")
                .address("San Fransisco, Green str 1")
                .build()

        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Jao_Wrong_Phone" )
                .lastName("Mclane")
                .phone("65432" )
                .email("email1@email.com")
                .address("San Fransisco, Green str 1")
                .build()

        });
        list.add(new Object[]{Contact.builder()
                .name("Jao_Wrong_Phone2" )
                .lastName("Mclane")
                .phone("6543223123123123" )
                .email("email1@email.com")
                .address("San Fransisco, Green str 1")
                .build()

        });

        list.add(new Object[]{Contact.builder()
                .name("Jao_Wrong_Phone3" )
                .lastName("Mclane")
                .phone("" )
                .email("email1@email.com")
                .address("San Fransisco, Green str 1")
                .build()

        });

        list.add(new Object[]{Contact.builder()
                .name("Jao_Wrong_Phone" )
                .lastName("Mclane")
                .phone("aabbddeeww" )
                .email("email1@email.com")
                .address("San Fransisco, Green str 1")
                .build()

        });
        return list.iterator();
    }

}
