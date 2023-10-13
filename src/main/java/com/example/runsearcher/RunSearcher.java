package com.example.runsearcher;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RunSearcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ResourceSetup resourceSetup = new ResourceSetup();
        resourceSetup.init();

        FXMLLoader fxmlLoader = new FXMLLoader(RunSearcher.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinWidth(1157);
        stage.setMinHeight(720);
        stage.setTitle("Hitless runs");

        Image image = new Image("icon.png");
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }

}