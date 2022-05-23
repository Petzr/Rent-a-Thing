package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.Seeder;

public class UserLogin {

    private Bedrijf bedrijf = new Bedrijf(new Seeder());

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void loginButtonPressed(ActionEvent event) {
        Medewerker medewerker = bedrijf.login(usernameField.getText(), passwordField.getText());
        System.out.println(medewerker);
        new MenuVenster(medewerker);
    }

}
