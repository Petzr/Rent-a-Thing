package com.rentathing;

import com.rentathing.IControllerInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.products.Product;
import source_code.products.factory.ProductFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OverzichtController implements IControllerInfo, Initializable {

    private Bedrijf bedrijf;
    private Medewerker medewerker;

    @FXML
    private TableColumn<?, ?> beschrijvingColumn;
    @FXML
    private Label errorMessage;
    @FXML
    private Label medewerkerLabel;
    @FXML
    private TableColumn<?, ?> productenColumn;
    @FXML
    private TableView<?> productenTable;

    @FXML
    void gaNaarDetailProduct(ActionEvent event) {
        if (getProductFromTable() == null) {
            errorMessage.setVisible(true);
            return;
        }
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        DetailController controller = new DetailController();
        controller.setProduct(getProductFromTable());
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "detail-venster.fxml", controller);

        stage.setScene(scene);
    }

    private Product getProductFromTable() {
        return ProductFactory.createBoormachine("merk", "typ");
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
        errorMessage.setVisible(false);
    }
}
