package com.example.runsearcher;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RunSearcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RunSearcher.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinWidth(1157);
        stage.setMaxWidth(1157);
        stage.setTitle("Hitless runs");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }

}