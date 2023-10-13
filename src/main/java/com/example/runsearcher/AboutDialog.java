package com.example.runsearcher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutDialog implements EventHandler<ActionEvent> {

    private final Button sourceButton;

    public AboutDialog(Button sourceButton) {
        this.sourceButton = sourceButton;
    }

    @Override
    public void handle(ActionEvent event) {



        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("aboutDialog.fxml"));
            Parent root = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(sourceButton.getScene().getWindow());
            dialogStage.setTitle("About");
            Image image = new Image("icon.png");
            dialogStage.getIcons().add(image);

            Scene scene = new Scene(root);
            dialogStage.setScene(scene);



            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
