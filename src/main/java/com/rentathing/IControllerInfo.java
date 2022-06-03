package com.rentathing;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import source_code.Bedrijf;
import source_code.people.Medewerker;

import java.io.IOException;

public interface IControllerInfo {

    void setMedewerker(Medewerker medewerker);
    void setBedrijf(Bedrijf bedrijf);

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
            System.out.println("GEEN FXMLFILE GEVONDEN");
            return null;
//            throw new RuntimeException(e);
        }

    }
}
