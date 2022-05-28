package com.rentathing;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import source_code.people.Medewerker;

import java.io.IOException;

public class MenuVenster extends Stage {

    private final Medewerker medewerker;

    public MenuVenster(Medewerker medewerker) {
        this.medewerker = medewerker;
        createStage();
    }

    private void createStage() {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuVenster.class.getResource("menu-venster.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("MENU VENSTER");
        setScene(scene);
        show();
    }
}
