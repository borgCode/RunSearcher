module com.example.runsearcher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires commons.csv;
    requires com.opencsv;
    requires java.desktop;




    opens com.example.runsearcher to javafx.fxml;
    exports com.example.runsearcher;
}