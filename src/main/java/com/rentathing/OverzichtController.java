package com.rentathing;

import com.rentathing.IControllerInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;
import source_code.products.Product;
import source_code.products.Vrachtwagen;
import source_code.products.factory.ProductFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OverzichtController implements IControllerInfo, Initializable {

    private Bedrijf bedrijf;
    private Medewerker medewerker;

    @FXML
    private Label errorMessage;
    @FXML
    private Label medewerkerLabel;
    @FXML
    private ListView<Product> productenList;

    @FXML
    void gaNaarDetailProduct(ActionEvent event) {
        if (getProductFromList() == null) {
            errorMessage.setVisible(true);
            return;
        }
        System.out.println(getProductFromList());

        Stage stage = IControllerInfo.getStage(event);
        DetailController controller = new DetailController();
        controller.setProduct(getProductFromList());
        Scene scene = IControllerInfo.createScene(bedrijf, medewerker, "detail-venster.fxml", controller);
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

        for (Product product : bedrijf.getProducts()) productenList.getItems().add(product);

        errorMessage.setVisible(false);
    }
}
