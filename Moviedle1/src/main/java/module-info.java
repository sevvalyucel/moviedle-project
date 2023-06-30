module com.example.moviedle1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moviedle1 to javafx.fxml;
    exports com.example.moviedle1;
}