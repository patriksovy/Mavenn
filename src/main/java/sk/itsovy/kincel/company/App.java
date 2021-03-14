package sk.itsovy.kincel.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.itsovy.kincel.company.database.Database;
import sk.itsovy.kincel.company.entity.User;
import sk.itsovy.kincel.company.enumeratori.Gender;
import sk.itsovy.kincel.company.util.Util;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}