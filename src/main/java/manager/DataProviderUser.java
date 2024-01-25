package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {


    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"liza19@gmail.com","Maksliza1914#"});
        list.add(new Object[]{"liza19@gmail.com","Maksliza1914#"});


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
       return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginModel(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("liza19@gmail.com").withPassword("Maksliza1914#")});
        return list.iterator();
    }
}
