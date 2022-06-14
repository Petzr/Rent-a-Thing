package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.Verhuur;
import source_code.people.Medewerker;
import source_code.products.Product;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class DetailController implements Initializable, IControllerInfo, Observer {

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
        Stage stage = IControllerInfo.getStage(event);

        HurenController controller = new HurenController();
        controller.setProduct(product);
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "huur-product.fxml", controller);
        stage.setScene(scene);
    }
    @FXML
    void productRetouren(ActionEvent event) {
        product.getVerhuur().retourProduct();
        setLabels();
    }
    @FXML
    void previousScene(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);

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
        product.addObserverToProduct(this);
        medewerkerLabel.setText(medewerker.getNaam());

        productSoort.setText(product.getClass().toString().substring(27));
        specsProduct.setText(product.korteOmschrijvingProduct());
        setLabels();
    }

    private void setLabels() {
        try {
            Verhuur verhuur = product.getVerhuur();
            productVerhuurtLabel.setText(product.getOpVoorraad() ? "op voorraad" : "niet op voorraad");
            productVerhuurtAanLabel.setText(verhuur.getVerhuurdAan() != null ? verhuur.getVerhuurdAan().toString() : "geen");
            productVerhuurtDoorLabel.setText(verhuur.getVerhuurdDoor() != null ? verhuur.getVerhuurdDoor().getNaam() : "geen");
        } catch (Exception e) {
            productVerhuurtLabel.setText(product.getOpVoorraad() ? "op voorraad" : "niet op voorraad");
            productVerhuurtAanLabel.setText("geen");
            productVerhuurtDoorLabel.setText("geen");

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setLabels();
    }
}
