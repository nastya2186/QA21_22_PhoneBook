package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {


    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                Contact.builder()
                        .name("Liza")
                        .lastName("Kim")
                        .phone("058")
                        .email("Nasty@gmail.com")
                        .address("Silver 10")
                        .description("second number 054898884")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Liza")
                        .lastName("Kim")
                        .phone("0588888838376465556565")
                        .email("Nasty@gmail.com")
                        .address("Silver 10")
                        .description("second number 054898884")
                        .build()
        });

        list.add(new Object[]{
                Contact.builder()
                        .name("Liza")
                        .lastName("Kim")
                        .phone("fbgfbgjfjff")
                        .email("Nasty@gmail.com")
                        .address("Silver 10")
                        .description("second number 054898884")
                        .build()
        });

        list.add(new Object[]{
                Contact.builder()
                        .name("Liza")
                        .lastName("Kim")
                        .phone("")
                        .email("Nasty@gmail.com")
                        .address("Silver 10")
                        .description("second number 054898884")
                        .build()
        });
        return list.iterator();
    }



    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
       list.add(new Object[]{
            Contact.builder()
                    .name("Liza")
                    .lastName("Kim")
                    .phone("05872855555")
                    .email("Nasty@gmail.com")
                    .address("Silver 10")
                    .description("second number 054898884")
                    .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Kiza")
                        .lastName("Klark")
                        .phone("05872843555")
                        .email("Sasty@gmail.com")
                        .address("Silver 10")
                        .description("second number 054898884")
                        .build()
        });
return list.iterator();
    }

}
