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
    private Label specsProduct;

    @FXML
    void productHuren(ActionEvent event) {

    }
    @FXML
    void productRetouren(ActionEvent event) {

    }
    @FXML
    void previousScene(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "overzicht-venster.fxml", new OverzichtController());
        stage.setScene(scene);
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
        medewerkerLabel.setText(medewerker.getNaam());

        productSoort.setText(product.getClass().toString().substring(27));
        specsProduct.setText(product.korteOmschrijvingProduct());
//        productVerhuurtAanLabel.setText(product.getVerhuurdAan().toString());
//        productVerhuurtLabel.setText(String.format("%b", product.getOpVoorraad()));
//        productVerhuurtDoorLabel.setText(product.getVerhuurdDoor().getNaam());
    }
}
