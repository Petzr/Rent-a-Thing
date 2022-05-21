package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserLoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void loginButtonPressed(ActionEvent event) {
        System.out.printf("%s, %s\n", usernameField.getText(), passwordField.getText());
        usernameField.setText("");
        passwordField.setText("");

    }

}
