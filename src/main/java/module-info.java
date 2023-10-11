module com.example.runsearcher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires commons.csv;
    requires com.opencsv;
    requires java.desktop;
    requires software.amazon.awssdk.services.s3;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.core;
    requires software.amazon.awssdk.regions;




    opens com.example.runsearcher to javafx.fxml;
    exports com.example.runsearcher;
}