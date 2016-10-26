package ua.golovchenko.artem.util.convert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.golovchenko.artem.strategy.model.User;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by art on 14.10.2016.
 * Source: http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 */
public class JavaToJSON {
    public static void main(String[] args) throws IOException {

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().create();
        User user = new User("MyName","MyLogin", "MyPassword");


// 1. Java object to JSON, and save into a file

            gson.toJson(user, new FileWriter("D:\\Artem\\java-projects\\Strategy_1\\src\\main\\resources\\user.json"));


        // 2. Java object to JSON, and assign to a String
        String jsonInString = gson.toJson(user);


    }
}
