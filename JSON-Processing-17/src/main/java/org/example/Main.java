package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String json =
                """
                 {
                      "username": "Denis",
                      "password": "Denis12345"
                 }        
                 """;

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

        LoginData loginData = new LoginData("Denis", "Denis12345");
        String result = gson.toJson(loginData);
        System.out.println(result);

//        LoginData loginData = gson.fromJson(json, LoginData.class);
//        System.out.println(loginData);
    }
}