package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.products.factory.ProductFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements IControllerInfo, Initializable {

    private Bedrijf bedrijf;
    private Medewerker medewerker;

    @FXML
    public Label medewerkerLabel;

    public void gaNaarBeheren(ActionEvent actionEvent) {
    }

    public void gaNaarOverzicht(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "overzicht-venster.fxml", new OverzichtController());

        stage.setScene(scene);
    }

    public void uitloggen(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        stage.close();
    }

    @Override
    public void setMedewerker(Medewerker medewerker) {
        this.medewerker = medewerker;
    }

    @Override
    public void setBedrijf(Bedrijf bedrijf) {
        this.bedrijf = bedrijf;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medewerkerLabel.setText(medewerker.getNaam());
    }
}
