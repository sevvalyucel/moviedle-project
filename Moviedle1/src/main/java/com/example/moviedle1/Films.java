package com.example.moviedle1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Films {

    private String no, title, year, genre, origin, director, star, imdbLink;

    public Films(String no, String Title, String Year, String Genre, String Origin, String Director, String Star, String ImdbLink) {
        this.no = no;
        this.title = Title;
        this.year = Year;
        this.genre = Genre;
        this.origin = Origin;
        this.director = Director;
        this.star = Star;
        this.imdbLink = ImdbLink;
    }

    //getters

    public String getNo() {
        return no;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public String getTitle() {
        return title;
    }

    public String getStar() {
        return star;
    }

    public String getDirector() {
        return director;
    }

    public String getOrigin() {
        return origin;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public static ArrayList<Films> films = new ArrayList<>();

    public static void movieReader(ArrayList<Films> films) {

        String path = "src/imdb_top_250.csv";// Eger program dosyayi bulamazsa lutfen dosya yolunu kendi donaniminiz olarak degistirin.

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
            String satir;


            while ((satir = reader.readLine()) != null) {

                String[] veriler = satir.split(";");
                satir.trim();

                String no = veriler[0];
                String title = veriler[1];
                String year = veriler[2];
                String genre = veriler[3];
                String origin = veriler[4];
                String director = veriler[5];
                String star = veriler[6];
                String imdbLink = veriler[7];



                films.add(new Films(no, title, year, genre, origin, director, star, imdbLink));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override

    public String toString() {
        return "No:" + no + title + year + genre + origin + director + star + imdbLink;
    }

    public static Films randomMovieChooser(ArrayList<Films> films) {
        Random rnd = new Random();
        int index = rnd.nextInt(films.size());
        System.out.println(films.get(index).toString());
        return films.get(index);

    }

}


