package com.example.runsearcher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class UpdateDialog implements EventHandler<ActionEvent> {

    private final FileDownloader fileDownloader;

    public UpdateDialog() {
        fileDownloader = new FileDownloader();
    }

    @Override
    public void handle(ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Update list");
        confirmation.setHeaderText("There will be an updated list available every Monday");
        confirmation.setContentText("A restart of the app is required once the file is downloaded");
        ((Button) confirmation.getDialogPane().lookupButton(ButtonType.OK)).setText("Update");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            fileDownloader.init();
        }

    }
}
