package com.rentathing;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import source_code.Bedrijf;
import source_code.people.Medewerker;

import java.io.IOException;

public interface IControllerInfo {

    void setMedewerker(Medewerker medewerker);
    void setBedrijf(Bedrijf bedrijf);

    static Stage getStage(Event event) {
        Node node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }

    static Scene createScene(Bedrijf bedrijf, Medewerker medewerker, String fxmlFile, IControllerInfo controller) {
        // fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(IControllerInfo.class.getResource(fxmlFile));

        // controller
        controller.setBedrijf(bedrijf);
        controller.setMedewerker(medewerker);
        fxmlLoader.setController(controller);

        // create Scene
        try {
            return new Scene(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("kan fxmlloader niet laden, fout met lezen van file");
            throw new RuntimeException(e);
//            return null;
        }

    }
}
