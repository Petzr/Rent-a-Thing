package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.products.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable, IControllerInfo {

    private Product product;
    private Bedrijf bedrijf;
    private Medewerker medewerker;

    @FXML
    private Label medewerkerLabel;
    @FXML
    private Label productSoort;
    @FXML
    private Label productVerhuurtAanLabel;
    @FXML
    private Label productVerhuurtDoorLabel;
    @FXML
    private Label productVerhuurtLabel;
    @FXML
    private Label spec1Product;
    @FXML
    private Label spec2Product;

    @FXML
    void productHuren(ActionEvent event) {

    }
    @FXML
    void productRetouren(ActionEvent event) {

    }
    @FXML
    void previeusScene(ActionEvent event) {

    }

    public void setProduct(Product product) {
        this.product = product;
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
//        medewerkerLabel.setText(medewerker.getNaam());
//
//        productSoort.setText(product.getClass().toString());
//        productVerhuurtAanLabel.setText(product.getVerhuurdAan().toString());
//        productVerhuurtLabel.setText(String.format("%b", product.getOpVoorraad()));
//        productVerhuurtDoorLabel.setText(product.getVerhuurdDoor().getNaam());
    }
}
