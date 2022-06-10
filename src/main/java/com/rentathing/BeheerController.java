package com.rentathing;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.products.Boormachine;
import source_code.products.PersonenAuto;
import source_code.products.Product;
import source_code.products.Vrachtwagen;

import java.net.URL;
import java.util.ResourceBundle;

public class BeheerController implements IControllerInfo, Initializable {

    private Medewerker medewerker;
    private Bedrijf bedrijf;

    @FXML
    private Label errorMessage;
    @FXML
    private Label medewerkerLabel;
    @FXML
    private ListView<Product> productenList;

    @FXML
    void gaNaarToevoegenProduct(ActionEvent event) {
        if (getProductFromList() == null) {
            errorMessage.setVisible(true);
            return;
        }
        Stage stage = IControllerInfo.getStage(event);

        ToevoegenController controller = new ToevoegenController();
        controller.setProduct(getProductFromList());
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "toevoegen-venster.fxml", controller);

        stage.setScene(scene);
    }
    @FXML
    void previousScene(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "menu-venster.fxml", new MenuController());
        stage.setScene(scene);
    }

    private Product getProductFromList() {
        return productenList.getSelectionModel().getSelectedItem();
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
        errorMessage.setVisible(false);

        productenList.setItems(FXCollections.observableArrayList(
                new Boormachine(null, null),
                new PersonenAuto(null, 1),
                new Vrachtwagen(1, 1)
        ));
    }
}
