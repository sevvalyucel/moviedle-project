package com.example.moviedle1;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

import static com.example.moviedle1.Films.films;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 650);
        stage.setTitle("Moviedle");
        URL url = getClass().getResource("/com/example/moviedle1/images/icon.png");
        Image icon=new Image(url.openStream());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {

        Films.movieReader(films);
        launch();


    }
}