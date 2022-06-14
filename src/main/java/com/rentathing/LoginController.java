package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.Seeder;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Bedrijf bedrijf;

    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField usernameField;

    @FXML
    void loginButtonPressed(ActionEvent event) {
        Medewerker medewerker = bedrijf.login(usernameField.getText(), passwordField.getText());
        if (medewerker == null) {
            errorMessage.setVisible(true);
            return;
        }
        errorMessage.setVisible(false);
        createNewMedewerkerMenuScherm(medewerker);
    }

    private void createNewMedewerkerMenuScherm(Medewerker medewerker) {
        Stage stage = new Stage();
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "menu-venster.fxml", new MenuController());
        stage.setTitle(medewerker.getNaam());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bedrijf = new Bedrijf(new Seeder());
        errorMessage.setVisible(false);

        usernameField.setText("Petzr");
        passwordField.setText("asdf");
    }
}
