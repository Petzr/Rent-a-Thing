package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.products.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class ToevoegenController implements IControllerInfo, Initializable {

    private Medewerker medewerker;
    private Bedrijf bedrijf;
    private Product product;

    @FXML
    private Label medewerkerLabel;
    @FXML
    private Label productSoort;
    @FXML
    private Label specsProduct;
    @FXML
    private TextField textfield1;
    @FXML
    private TextField textfield2;

    @FXML
    void createNieuwProduct(ActionEvent event) {

    }
    @FXML
    void previousScene(ActionEvent event) {

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
    }
}
