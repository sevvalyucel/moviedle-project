package com.example.moviedle1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Movies {

    public static void filmReader(){
        String path = "src/imdb_top_250.csv";

        ArrayList<String> films = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String satir;

            while ((satir = reader.readLine()) != null) {
                satir.split(";");
                films.add(satir);
            }


            for (String veri : films) {
                System.out.println(veri);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
