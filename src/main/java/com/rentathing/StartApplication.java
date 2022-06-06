package com.rentathing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // deze fxml applicatie werkt nog niet.
        // ben hier wel mee bezig in een aparte branch
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("user-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("USER LOGIN");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}