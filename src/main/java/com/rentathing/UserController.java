package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.Seeder;

import java.io.IOException;

public class UserController {

    private Bedrijf bedrijf = new Bedrijf(new Seeder());

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void loginButtonPressed(ActionEvent event) {
        Medewerker medewerker = bedrijf.login(usernameField.getText(), passwordField.getText());
        System.out.println(medewerker);

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(UserController.class.getResource("menu-venster.fxml"));
        Scene scene = IControllerInfo.createScene(medewerker, "menu-venster.fxml", new MenuController());
        stage.setTitle("medewerker");
        stage.setScene(scene);
        stage.show();

    }

}
