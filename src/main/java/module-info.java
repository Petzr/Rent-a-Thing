module com.rentathing {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;

    opens com.rentathing to javafx.fxml;
    exports com.rentathing;
    exports com.rentathing.controller;
    opens com.rentathing.controller to javafx.fxml;
}