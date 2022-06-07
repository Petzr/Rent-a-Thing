package com.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import source_code.Bedrijf;
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
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        DetailController controller = new DetailController();
        controller.setProduct(product);
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "detail-venster.fxml", controller);
        stage.setScene(scene);
    }

    @FXML
    void bevestigHuren(ActionEvent event) {

    }

    @FXML
    void zekerProductHuren(ActionEvent event) {
        System.out.println(aantalDagenS.getValue());
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
