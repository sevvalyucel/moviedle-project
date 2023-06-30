package com.example.moviedle1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Optional;

import static com.example.moviedle1.Films.films;

public class Controller {
    @FXML
    private Label lbl1_1;
    @FXML
    private Label lbl1_2;
    @FXML
    private Label lbl1_3;
    @FXML
    private Label lbl1_4;
    @FXML
    private Label lbl1_5;
    @FXML
    private Label lbl1_6;
    @FXML
    private Label lbl2_1;
    @FXML
    private Label lbl2_2;
    @FXML
    private Label lbl2_3;
    @FXML
    private Label lbl2_4;
    @FXML
    private Label lbl2_5;
    @FXML
    private Label lbl2_6;
    @FXML
    private Label lbl3_1;
    @FXML
    private Label lbl3_2;
    @FXML
    private Label lbl3_3;
    @FXML
    private Label lbl3_4;
    @FXML
    private Label lbl3_5;
    @FXML
    private Label lbl3_6;
    @FXML
    private Label lbl4_1;

    @FXML
    private Label lbl4_2;

    @FXML
    private Label lbl4_3;

    @FXML
    private Label lbl4_4;

    @FXML
    private Label lbl4_5;

    @FXML
    private Label lbl4_6;

    @FXML
    private Label lbl5_1;

    @FXML
    private Label lbl5_2;

    @FXML
    private Label lbl5_3;

    @FXML
    private Label lbl5_4;

    @FXML
    private Label lbl5_5;

    @FXML
    private Label lbl5_6;
    @FXML
    private TextField textfield;


    int clickCount = 0;
    Films chosen = Films.randomMovieChooser(films);

    @FXML
    protected void buttonSetOnAction() {
        String text = textfield.getText();

        boolean isItAvailable = false;

        for (Films film : films) {
            if (film.getTitle().equalsIgnoreCase(textfield.getText())) {
                isItAvailable = true;
                break;
            }
        }

        if (!isItAvailable) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Movie not found!");
            alert.setContentText("The movie you were looking for was not found.");
            alert.showAndWait();
        }


        if (clickCount == 0) {

            clickCount++;

            if (text.equalsIgnoreCase(chosen.getTitle())) {
                lbl1_1.setText(chosen.getTitle());
                lbl1_1.setStyle("-fx-background-color: green");
                lbl1_2.setText(chosen.getYear());
                lbl1_2.setStyle("-fx-background-color: green");
                lbl1_3.setText(chosen.getGenre());
                lbl1_3.setStyle("-fx-background-color: green");
                lbl1_4.setText(chosen.getOrigin());
                lbl1_4.setStyle("-fx-background-color: green");
                lbl1_5.setText(chosen.getDirector());
                lbl1_5.setStyle("-fx-background-color: green");
                lbl1_6.setText(chosen.getStar());
                lbl1_6.setStyle("-fx-background-color: green");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You win!");
                alert.setHeaderText("Hey!");
                alert.setContentText("Do you want to play again?");
                ButtonType tryAgainButton = new ButtonType("Try Again");
                ButtonType quitButton = new ButtonType("Quit");
                alert.getButtonTypes().setAll(tryAgainButton, quitButton);
                Optional<ButtonType> result = alert.showAndWait();
                result.ifPresent(response -> {
                    if (response == tryAgainButton) {
                        textfield.clear();
                        chosen = Films.randomMovieChooser(films);
                        lbl1_1.setText("");
                        lbl1_2.setText("");
                        lbl1_3.setText("");
                        lbl1_4.setText("");
                        lbl1_5.setText("");
                        lbl1_6.setText("");
                        lbl1_1.setStyle("-fx-background-color: transparent");
                        lbl1_2.setStyle("-fx-background-color: transparent");
                        lbl1_3.setStyle("-fx-background-color: transparent");
                        lbl1_4.setStyle("-fx-background-color: transparent");
                        lbl1_5.setStyle("-fx-background-color: transparent");
                        lbl1_6.setStyle("-fx-background-color: transparent");
                        clickCount = 0;
                    } else {
                        alert.setOnCloseRequest(event -> {
                            Platform.exit();
                        });
                    }

                });
            } else {
                for (Films film : films) {
                    if (film.getTitle().equals(textfield.getText())) {
                        lbl1_1.setText(film.getTitle());
                        lbl1_2.setText(film.getYear());
                        lbl1_3.setText(film.getGenre());
                        lbl1_4.setText(film.getOrigin());
                        lbl1_5.setText(film.getDirector());
                        lbl1_6.setText(film.getStar());

                        if (chosen.getTitle().equalsIgnoreCase(film.getTitle()))
                            lbl1_1.setStyle("-fx-background-color: green");
                        else
                            lbl1_1.setStyle("-fx-background-color: red");


                        if (chosen.getYear().equalsIgnoreCase(film.getYear()))
                            lbl1_2.setStyle("-fx-background-color: green");
                        else
                            lbl1_2.setStyle("-fx-background-color: red");


                        if (chosen.getGenre().equalsIgnoreCase(film.getGenre()))
                            lbl1_3.setStyle("-fx-background-color: green");
                        else
                            lbl1_3.setStyle("-fx-background-color: red");

                        if (chosen.getOrigin().equalsIgnoreCase(film.getOrigin()))
                            lbl1_4.setStyle("-fx-background-color: green");
                        else
                            lbl1_4.setStyle("-fx-background-color: red");

                        if (chosen.getDirector().equalsIgnoreCase(film.getDirector()))
                            lbl1_5.setStyle("-fx-background-color: green");
                        else
                            lbl1_5.setStyle("-fx-background-color: red");

                        if (chosen.getStar().equalsIgnoreCase(film.getStar()))
                            lbl1_6.setStyle("-fx-background-color: green");
                        else
                            lbl1_6.setStyle("-fx-background-color: red");


                    }
                }

            }
        } else if (clickCount == 1) {
            clickCount++;
            if (text.equalsIgnoreCase(chosen.getTitle())) {
                lbl2_1.setText(chosen.getTitle());
                lbl2_1.setStyle("-fx-background-color: green");
                lbl2_2.setText(chosen.getYear());
                lbl2_2.setStyle("-fx-background-color: green");
                lbl2_3.setText(chosen.getGenre());
                lbl2_3.setStyle("-fx-background-color: green");
                lbl2_4.setText(chosen.getOrigin());
                lbl2_4.setStyle("-fx-background-color: green");
                lbl2_5.setText(chosen.getDirector());
                lbl2_5.setStyle("-fx-background-color: green");
                lbl2_6.setText(chosen.getStar());
                lbl2_6.setStyle("-fx-background-color: green");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You win!");
                alert.setContentText("Do you want to play again?");
                ButtonType tryAgainButton = new ButtonType("Try Again");
                ButtonType quitButton = new ButtonType("Quit");
                alert.getButtonTypes().setAll(tryAgainButton, quitButton);
                Optional<ButtonType> result = alert.showAndWait();
                result.ifPresent(response -> {
                    if (response == tryAgainButton) {
                        chosen = Films.randomMovieChooser(films);
                        textfield.clear();
                        lbl1_1.setText("");
                        lbl1_2.setText("");
                        lbl1_3.setText("");
                        lbl1_4.setText("");
                        lbl1_5.setText("");
                        lbl1_6.setText("");
                        lbl1_1.setStyle("-fx-background-color: transparent");
                        lbl1_2.setStyle("-fx-background-color: transparent");
                        lbl1_3.setStyle("-fx-background-color: transparent");
                        lbl1_4.setStyle("-fx-background-color: transparent");
                        lbl1_5.setStyle("-fx-background-color: transparent");
                        lbl1_6.setStyle("-fx-background-color: transparent");
                        lbl2_1.setText("");
                        lbl2_2.setText("");
                        lbl2_3.setText("");
                        lbl2_4.setText("");
                        lbl2_5.setText("");
                        lbl2_6.setText("");
                        lbl2_1.setStyle("-fx-background-color: transparent");
                        lbl2_2.setStyle("-fx-background-color: transparent");
                        lbl2_3.setStyle("-fx-background-color: transparent");
                        lbl2_4.setStyle("-fx-background-color: transparent");
                        lbl2_5.setStyle("-fx-background-color: transparent");
                        lbl2_6.setStyle("-fx-background-color: transparent");
                        clickCount = 0;
                    } else {
                        alert.setOnCloseRequest(event -> {
                            Platform.exit();
                        });
                    }
                });

            } else {
                for (Films film : films) {
                    if (film.getTitle().equalsIgnoreCase(textfield.getText())) {
                        lbl2_1.setText(film.getTitle());
                        lbl2_2.setText(film.getYear());
                        lbl2_3.setText(film.getGenre());
                        lbl2_4.setText(film.getOrigin());
                        lbl2_5.setText(film.getDirector());
                        lbl2_6.setText(film.getStar());

                        if (chosen.getTitle().equalsIgnoreCase(film.getTitle()))
                            lbl2_1.setStyle("-fx-background-color: green");
                        else
                            lbl2_1.setStyle("-fx-background-color: red");


                        if (chosen.getYear().equalsIgnoreCase(film.getYear()))
                            lbl2_2.setStyle("-fx-background-color: green");
                        else
                            lbl2_2.setStyle("-fx-background-color: red");


                        if (chosen.getGenre().equalsIgnoreCase(film.getGenre()))
                            lbl2_3.setStyle("-fx-background-color: green");
                        else
                            lbl2_3.setStyle("-fx-background-color: red");

                        if (chosen.getOrigin().equalsIgnoreCase(film.getOrigin()))
                            lbl2_4.setStyle("-fx-background-color: green");
                        else
                            lbl2_4.setStyle("-fx-background-color: red");

                        if (chosen.getDirector().equalsIgnoreCase(film.getDirector()))
                            lbl2_5.setStyle("-fx-background-color: green");
                        else
                            lbl2_5.setStyle("-fx-background-color: red");

                        if (chosen.getStar().equalsIgnoreCase(film.getStar()))
                            lbl2_6.setStyle("-fx-background-color: green");
                        else
                            lbl2_6.setStyle("-fx-background-color: red");


                    }
                }
            }
        } else if (clickCount == 2) {
            clickCount++;
            if (text.equalsIgnoreCase(chosen.getTitle())) {
                lbl3_1.setText(chosen.getTitle());
                lbl3_1.setStyle("-fx-background-color: green");
                lbl3_2.setText(chosen.getYear());
                lbl3_2.setStyle("-fx-background-color: green");
                lbl3_3.setText(chosen.getGenre());
                lbl3_3.setStyle("-fx-background-color: green");
                lbl3_4.setText(chosen.getOrigin());
                lbl3_4.setStyle("-fx-background-color: green");
                lbl3_5.setText(chosen.getDirector());
                lbl3_5.setStyle("-fx-background-color: green");
                lbl3_6.setText(chosen.getStar());
                lbl3_6.setStyle("-fx-background-color: green");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You win!");
                alert.setContentText("Do you want to play again?");
                ButtonType tryAgainButton = new ButtonType("Try Again");
                ButtonType quitButton = new ButtonType("Quit");
                alert.getButtonTypes().setAll(tryAgainButton, quitButton);
                Optional<ButtonType> result = alert.showAndWait();
                result.ifPresent(response -> {
                    if (response == tryAgainButton) {
                        chosen = Films.randomMovieChooser(films);
                        textfield.clear();
                        lbl1_1.setText("");
                        lbl1_2.setText("");
                        lbl1_3.setText("");
                        lbl1_4.setText("");
                        lbl1_5.setText("");
                        lbl1_6.setText("");
                        lbl1_1.setStyle("-fx-background-color: transparent");
                        lbl1_2.setStyle("-fx-background-color: transparent");
                        lbl1_3.setStyle("-fx-background-color: transparent");
                        lbl1_4.setStyle("-fx-background-color: transparent");
                        lbl1_5.setStyle("-fx-background-color: transparent");
                        lbl1_6.setStyle("-fx-background-color: transparent");
                        lbl2_1.setText("");
                        lbl2_2.setText("");
                        lbl2_3.setText("");
                        lbl2_4.setText("");
                        lbl2_5.setText("");
                        lbl2_6.setText("");
                        lbl2_1.setStyle("-fx-background-color: transparent");
                        lbl2_2.setStyle("-fx-background-color: transparent");
                        lbl2_3.setStyle("-fx-background-color: transparent");
                        lbl2_4.setStyle("-fx-background-color: transparent");
                        lbl2_5.setStyle("-fx-background-color: transparent");
                        lbl2_6.setStyle("-fx-background-color: transparent");
                        lbl3_1.setText("");
                        lbl3_2.setText("");
                        lbl3_3.setText("");
                        lbl3_4.setText("");
                        lbl3_5.setText("");
                        lbl3_6.setText("");
                        lbl3_1.setStyle("-fx-background-color: transparent");
                        lbl3_2.setStyle("-fx-background-color: transparent");
                        lbl3_3.setStyle("-fx-background-color: transparent");
                        lbl3_4.setStyle("-fx-background-color: transparent");
                        lbl3_5.setStyle("-fx-background-color: transparent");
                        lbl3_6.setStyle("-fx-background-color: transparent");
                        clickCount = 0;
                    } else {
                        alert.setOnCloseRequest(event -> {
                            Platform.exit();
                        });
                    }
                });

            } else {
                for (Films film : films) {
                    if (film.getTitle().equalsIgnoreCase(textfield.getText())) {
                        lbl3_1.setText(film.getTitle());
                        lbl3_2.setText(film.getYear());
                        lbl3_3.setText(film.getGenre());
                        lbl3_4.setText(film.getOrigin());
                        lbl3_5.setText(film.getDirector());
                        lbl3_6.setText(film.getStar());

                        if (chosen.getTitle().equalsIgnoreCase(film.getTitle()))
                            lbl3_1.setStyle("-fx-background-color: green");
                        else
                            lbl3_1.setStyle("-fx-background-color: red");


                        if (chosen.getYear().equalsIgnoreCase(film.getYear()))
                            lbl3_2.setStyle("-fx-background-color: green");
                        else
                            lbl3_2.setStyle("-fx-background-color: red");


                        if (chosen.getGenre().equalsIgnoreCase(film.getGenre()))
                            lbl3_3.setStyle("-fx-background-color: green");
                        else
                            lbl3_3.setStyle("-fx-background-color: red");

                        if (chosen.getOrigin().equalsIgnoreCase(film.getOrigin()))
                            lbl3_4.setStyle("-fx-background-color: green");
                        else
                            lbl3_4.setStyle("-fx-background-color: red");

                        if (chosen.getDirector().equalsIgnoreCase(film.getDirector()))
                            lbl3_5.setStyle("-fx-background-color: green");
                        else
                            lbl3_5.setStyle("-fx-background-color: red");

                        if (chosen.getStar().equalsIgnoreCase(film.getStar()))
                            lbl3_6.setStyle("-fx-background-color: green");
                        else
                            lbl3_6.setStyle("-fx-background-color: red");


                    }
                }
            }
        } else if (clickCount == 3) {
            clickCount++;
            if (text.equalsIgnoreCase(chosen.getTitle())) {
                lbl4_1.setText(chosen.getTitle());
                lbl4_1.setStyle("-fx-background-color: green");
                lbl4_2.setText(chosen.getYear());
                lbl4_2.setStyle("-fx-background-color: green");
                lbl4_3.setText(chosen.getGenre());
                lbl4_3.setStyle("-fx-background-color: green");
                lbl4_4.setText(chosen.getOrigin());
                lbl4_4.setStyle("-fx-background-color: green");
                lbl4_5.setText(chosen.getDirector());
                lbl4_5.setStyle("-fx-background-color: green");
                lbl4_6.setText(chosen.getStar());
                lbl4_6.setStyle("-fx-background-color: green");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You win!");
                alert.setContentText("Do you want to play again?");
                ButtonType tryAgainButton = new ButtonType("Try Again");
                ButtonType quitButton = new ButtonType("Quit");
                alert.getButtonTypes().setAll(tryAgainButton, quitButton);
                Optional<ButtonType> result = alert.showAndWait();
                result.ifPresent(response -> {
                    if (response == tryAgainButton) {
                        chosen = Films.randomMovieChooser(films);
                        textfield.clear();
                        lbl1_1.setText("");
                        lbl1_2.setText("");
                        lbl1_3.setText("");
                        lbl1_4.setText("");
                        lbl1_5.setText("");
                        lbl1_6.setText("");
                        lbl1_1.setStyle("-fx-background-color: transparent");
                        lbl1_2.setStyle("-fx-background-color: transparent");
                        lbl1_3.setStyle("-fx-background-color: transparent");
                        lbl1_4.setStyle("-fx-background-color: transparent");
                        lbl1_5.setStyle("-fx-background-color: transparent");
                        lbl1_6.setStyle("-fx-background-color: transparent");
                        lbl2_1.setText("");
                        lbl2_2.setText("");
                        lbl2_3.setText("");
                        lbl2_4.setText("");
                        lbl2_5.setText("");
                        lbl2_6.setText("");
                        lbl2_1.setStyle("-fx-background-color: transparent");
                        lbl2_2.setStyle("-fx-background-color: transparent");
                        lbl2_3.setStyle("-fx-background-color: transparent");
                        lbl2_4.setStyle("-fx-background-color: transparent");
                        lbl2_5.setStyle("-fx-background-color: transparent");
                        lbl2_6.setStyle("-fx-background-color: transparent");
                        lbl3_1.setText("");
                        lbl3_2.setText("");
                        lbl3_3.setText("");
                        lbl3_4.setText("");
                        lbl3_5.setText("");
                        lbl3_6.setText("");
                        lbl3_1.setStyle("-fx-background-color: transparent");
                        lbl3_2.setStyle("-fx-background-color: transparent");
                        lbl3_3.setStyle("-fx-background-color: transparent");
                        lbl3_4.setStyle("-fx-background-color: transparent");
                        lbl3_5.setStyle("-fx-background-color: transparent");
                        lbl3_6.setStyle("-fx-background-color: transparent");
                        lbl4_1.setText("");
                        lbl4_2.setText("");
                        lbl4_3.setText("");
                        lbl4_4.setText("");
                        lbl4_5.setText("");
                        lbl4_6.setText("");
                        lbl4_1.setStyle("-fx-background-color: transparent");
                        lbl4_2.setStyle("-fx-background-color: transparent");
                        lbl4_3.setStyle("-fx-background-color: transparent");
                        lbl4_4.setStyle("-fx-background-color: transparent");
                        lbl4_5.setStyle("-fx-background-color: transparent");
                        lbl4_6.setStyle("-fx-background-color: transparent");
                        clickCount = 0;
                    } else {
                        alert.setOnCloseRequest(event -> {
                            Platform.exit();
                        });
                    }
                });

            } else {
                for (Films film : films) {
                    if (film.getTitle().equalsIgnoreCase(textfield.getText())) {
                        lbl4_1.setText(film.getTitle());
                        lbl4_2.setText(film.getYear());
                        lbl4_3.setText(film.getGenre());
                        lbl4_4.setText(film.getOrigin());
                        lbl4_5.setText(film.getDirector());
                        lbl4_6.setText(film.getStar());

                        if (chosen.getTitle().equalsIgnoreCase(film.getTitle()))
                            lbl4_1.setStyle("-fx-background-color: green");
                        else
                            lbl4_1.setStyle("-fx-background-color: red");


                        if (chosen.getYear().equalsIgnoreCase(film.getYear()))
                            lbl4_2.setStyle("-fx-background-color: green");
                        else
                            lbl4_2.setStyle("-fx-background-color: red");


                        if (chosen.getGenre().equalsIgnoreCase(film.getGenre()))
                            lbl4_3.setStyle("-fx-background-color: green");
                        else
                            lbl4_3.setStyle("-fx-background-color: red");

                        if (chosen.getOrigin().equalsIgnoreCase(film.getOrigin()))
                            lbl4_4.setStyle("-fx-background-color: green");
                        else
                            lbl4_4.setStyle("-fx-background-color: red");

                        if (chosen.getDirector().equalsIgnoreCase(film.getDirector()))
                            lbl4_5.setStyle("-fx-background-color: green");
                        else
                            lbl4_5.setStyle("-fx-background-color: red");

                        if (chosen.getStar().equalsIgnoreCase(film.getStar()))
                            lbl4_6.setStyle("-fx-background-color: green");
                        else
                            lbl4_6.setStyle("-fx-background-color: red");


                    }
                }
            }
        } else if (clickCount == 4) {
            clickCount++;
            if (text.equalsIgnoreCase(chosen.getTitle())) {
                lbl5_1.setText(chosen.getTitle());
                lbl5_1.setStyle("-fx-background-color: green");
                lbl5_2.setText(chosen.getYear());
                lbl5_2.setStyle("-fx-background-color: green");
                lbl5_3.setText(chosen.getGenre());
                lbl5_3.setStyle("-fx-background-color: green");
                lbl5_4.setText(chosen.getOrigin());
                lbl5_4.setStyle("-fx-background-color: green");
                lbl5_5.setText(chosen.getDirector());
                lbl5_5.setStyle("-fx-background-color: green");
                lbl5_6.setText(chosen.getStar());
                lbl5_6.setStyle("-fx-background-color: green");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You win!");
                alert.setContentText("Do you want to play again?");
                ButtonType tryAgainButton = new ButtonType("Try Again");
                ButtonType quitButton = new ButtonType("Quit");
                alert.getButtonTypes().setAll(tryAgainButton, quitButton);
                Optional<ButtonType> result = alert.showAndWait();
                result.ifPresent(response -> {
                    if (response == tryAgainButton) {
                        chosen = Films.randomMovieChooser(films);
                        textfield.clear();
                        lbl1_1.setText("");
                        lbl1_2.setText("");
                        lbl1_3.setText("");
                        lbl1_4.setText("");
                        lbl1_5.setText("");
                        lbl1_6.setText("");
                        lbl1_1.setStyle("-fx-background-color: transparent");
                        lbl1_2.setStyle("-fx-background-color: transparent");
                        lbl1_3.setStyle("-fx-background-color: transparent");
                        lbl1_4.setStyle("-fx-background-color: transparent");
                        lbl1_5.setStyle("-fx-background-color: transparent");
                        lbl1_6.setStyle("-fx-background-color: transparent");
                        lbl2_1.setText("");
                        lbl2_2.setText("");
                        lbl2_3.setText("");
                        lbl2_4.setText("");
                        lbl2_5.setText("");
                        lbl2_6.setText("");
                        lbl2_1.setStyle("-fx-background-color: transparent");
                        lbl2_2.setStyle("-fx-background-color: transparent");
                        lbl2_3.setStyle("-fx-background-color: transparent");
                        lbl2_4.setStyle("-fx-background-color: transparent");
                        lbl2_5.setStyle("-fx-background-color: transparent");
                        lbl2_6.setStyle("-fx-background-color: transparent");
                        lbl3_1.setText("");
                        lbl3_2.setText("");
                        lbl3_3.setText("");
                        lbl3_4.setText("");
                        lbl3_5.setText("");
                        lbl3_6.setText("");
                        lbl3_1.setStyle("-fx-background-color: transparent");
                        lbl3_2.setStyle("-fx-background-color: transparent");
                        lbl3_3.setStyle("-fx-background-color: transparent");
                        lbl3_4.setStyle("-fx-background-color: transparent");
                        lbl3_5.setStyle("-fx-background-color: transparent");
                        lbl3_6.setStyle("-fx-background-color: transparent");
                        lbl4_1.setText("");
                        lbl4_2.setText("");
                        lbl4_3.setText("");
                        lbl4_4.setText("");
                        lbl4_5.setText("");
                        lbl4_6.setText("");
                        lbl4_1.setStyle("-fx-background-color: transparent");
                        lbl4_2.setStyle("-fx-background-color: transparent");
                        lbl4_3.setStyle("-fx-background-color: transparent");
                        lbl4_4.setStyle("-fx-background-color: transparent");
                        lbl4_5.setStyle("-fx-background-color: transparent");
                        lbl4_6.setStyle("-fx-background-color: transparent");
                        lbl5_1.setText("");
                        lbl5_2.setText("");
                        lbl5_3.setText("");
                        lbl5_4.setText("");
                        lbl5_5.setText("");
                        lbl5_6.setText("");
                        lbl5_1.setStyle("-fx-background-color: transparent");
                        lbl5_2.setStyle("-fx-background-color: transparent");
                        lbl5_3.setStyle("-fx-background-color: transparent");
                        lbl5_4.setStyle("-fx-background-color: transparent");
                        lbl5_5.setStyle("-fx-background-color: transparent");
                        lbl5_6.setStyle("-fx-background-color: transparent");
                        clickCount = 0;
                    } else {
                        alert.setOnCloseRequest(event -> {
                            Platform.exit();
                        });
                    }
                });

            } else {
                for (Films film : films) {
                    if (film.getTitle().equalsIgnoreCase(textfield.getText())) {
                        lbl5_1.setText(film.getTitle());
                        lbl5_2.setText(film.getYear());
                        lbl5_3.setText(film.getGenre());
                        lbl5_4.setText(film.getOrigin());
                        lbl5_5.setText(film.getDirector());
                        lbl5_6.setText(film.getStar());

                        if (chosen.getTitle().equalsIgnoreCase(film.getTitle()))
                            lbl5_1.setStyle("-fx-background-color: green");
                        else
                            lbl5_1.setStyle("-fx-background-color: red");


                        if (chosen.getYear().equalsIgnoreCase(film.getYear()))
                            lbl5_2.setStyle("-fx-background-color: green");
                        else
                            lbl5_2.setStyle("-fx-background-color: red");


                        if (chosen.getGenre().equalsIgnoreCase(film.getGenre()))
                            lbl5_3.setStyle("-fx-background-color: green");
                        else
                            lbl5_3.setStyle("-fx-background-color: red");

                        if (chosen.getOrigin().equalsIgnoreCase(film.getOrigin()))
                            lbl5_4.setStyle("-fx-background-color: green");
                        else
                            lbl5_4.setStyle("-fx-background-color: red");

                        if (chosen.getDirector().equalsIgnoreCase(film.getDirector()))
                            lbl5_5.setStyle("-fx-background-color: green");
                        else
                            lbl5_5.setStyle("-fx-background-color: red");

                        if (chosen.getStar().equalsIgnoreCase(film.getStar()))
                            lbl5_6.setStyle("-fx-background-color: green");
                        else
                            lbl5_6.setStyle("-fx-background-color: red");


                    }
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("You lost the game!");
                alert.setContentText("Do you want to play again?");
                ButtonType tryAgainButton = new ButtonType("Try Again");
                ButtonType quitButton = new ButtonType("Quit");
                alert.getButtonTypes().setAll(tryAgainButton, quitButton);
                Optional<ButtonType> result = alert.showAndWait();
                result.ifPresent(response -> {
                    if (response == tryAgainButton) {
                        chosen = Films.randomMovieChooser(films);
                        textfield.clear();
                        lbl1_1.setText("");
                        lbl1_2.setText("");
                        lbl1_3.setText("");
                        lbl1_4.setText("");
                        lbl1_5.setText("");
                        lbl1_6.setText("");
                        lbl1_1.setStyle("-fx-background-color: transparent");
                        lbl1_2.setStyle("-fx-background-color: transparent");
                        lbl1_3.setStyle("-fx-background-color: transparent");
                        lbl1_4.setStyle("-fx-background-color: transparent");
                        lbl1_5.setStyle("-fx-background-color: transparent");
                        lbl1_6.setStyle("-fx-background-color: transparent");
                        lbl2_1.setText("");
                        lbl2_2.setText("");
                        lbl2_3.setText("");
                        lbl2_4.setText("");
                        lbl2_5.setText("");
                        lbl2_6.setText("");
                        lbl2_1.setStyle("-fx-background-color: transparent");
                        lbl2_2.setStyle("-fx-background-color: transparent");
                        lbl2_3.setStyle("-fx-background-color: transparent");
                        lbl2_4.setStyle("-fx-background-color: transparent");
                        lbl2_5.setStyle("-fx-background-color: transparent");
                        lbl2_6.setStyle("-fx-background-color: transparent");
                        lbl3_1.setText("");
                        lbl3_2.setText("");
                        lbl3_3.setText("");
                        lbl3_4.setText("");
                        lbl3_5.setText("");
                        lbl3_6.setText("");
                        lbl3_1.setStyle("-fx-background-color: transparent");
                        lbl3_2.setStyle("-fx-background-color: transparent");
                        lbl3_3.setStyle("-fx-background-color: transparent");
                        lbl3_4.setStyle("-fx-background-color: transparent");
                        lbl3_5.setStyle("-fx-background-color: transparent");
                        lbl3_6.setStyle("-fx-background-color: transparent");
                        lbl4_1.setText("");
                        lbl4_2.setText("");
                        lbl4_3.setText("");
                        lbl4_4.setText("");
                        lbl4_5.setText("");
                        lbl4_6.setText("");
                        lbl4_1.setStyle("-fx-background-color: transparent");
                        lbl4_2.setStyle("-fx-background-color: transparent");
                        lbl4_3.setStyle("-fx-background-color: transparent");
                        lbl4_4.setStyle("-fx-background-color: transparent");
                        lbl4_5.setStyle("-fx-background-color: transparent");
                        lbl4_6.setStyle("-fx-background-color: transparent");
                        lbl5_1.setText("");
                        lbl5_2.setText("");
                        lbl5_3.setText("");
                        lbl5_4.setText("");
                        lbl5_5.setText("");
                        lbl5_6.setText("");
                        lbl5_1.setStyle("-fx-background-color: transparent");
                        lbl5_2.setStyle("-fx-background-color: transparent");
                        lbl5_3.setStyle("-fx-background-color: transparent");
                        lbl5_4.setStyle("-fx-background-color: transparent");
                        lbl5_5.setStyle("-fx-background-color: transparent");
                        lbl5_6.setStyle("-fx-background-color: transparent");
                        clickCount = 0;
                    } else {
                        alert.setOnCloseRequest(event -> {
                            Platform.exit();
                        });
                    }
                });


            }

        }
    }
}

