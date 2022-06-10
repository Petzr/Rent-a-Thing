package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Klant;
import source_code.people.Medewerker;
import source_code.products.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class HurenController implements IControllerInfo, Initializable {

    private Medewerker medewerker;
    private Bedrijf bedrijf;
    private Product product;

    @FXML
    private Spinner<Integer> aantalDagenS;
    @FXML
    private CheckBox isVerzekerdCB;
    @FXML
    private TextField klantAchternaamTF;
    @FXML
    private TextField klantVoornaamTF;
    @FXML
    private Label medewerkerLabel;
    @FXML
    private Label productKostenPerDagLabel;
    @FXML
    private Label productSoort;
    @FXML
    private Label productenKostenMetVezekering;
    @FXML
    private Label specsProduct;
    @FXML
    private Label totaalPrijsLabel;
    @FXML
    private Button bevestigenButton;

    @FXML
    void previousScene(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);

        DetailController controller = new DetailController();
        controller.setProduct(product);
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "detail-venster.fxml", controller);
        stage.setScene(scene);
    }

    @FXML
    void bevestigHuren(ActionEvent event) {
        product.setVerhuurdDoor(medewerker);
        Klant klant = new Klant(klantVoornaamTF.getText(), klantAchternaamTF.getText());
        product.setVerhuurdAan(klant);

        product.setOpVoorraad(false);

        previousScene(event);
    }

    @FXML
    void zekerProductHuren(ActionEvent event) {
        if (klantVoornaamTF.getText().equals("") || klantAchternaamTF.getText().equals("")) return;

        totaalPrijsLabel.setVisible(true);
        bevestigenButton.setVisible(true);
        totaalPrijsLabel.setText(String.valueOf(product.getVerhuurPrijs(aantalDagenS.getValue(),isVerzekerdCB.isSelected())));
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

        productKostenPerDagLabel.setText(String.valueOf(product.getVerhuurPrijs(1, false)));
        productenKostenMetVezekering.setText(String.valueOf(product.getVerhuurPrijs(1, true)));

        totaalPrijsLabel.setVisible(false);
        bevestigenButton.setVisible(false);

        aantalDagenS.setEditable(true);
        aantalDagenS.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 365, 1));
    }
}
