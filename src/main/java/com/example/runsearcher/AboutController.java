package com.example.runsearcher;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutController {

    @FXML
    private ImageView githubImage;

    @FXML
    private Hyperlink githubLink;

    @FXML
    private ImageView runSearchIcon;

    @FXML
    private ImageView twitchImage;

    @FXML
    private Hyperlink twitchLink;

    @FXML
    public void initialize() {
        Image logo = new Image("icon.png");
        Image twitch = new Image("twitch.png");
        Image github = new Image("github.png");

        runSearchIcon.setImage(logo);
        twitchImage.setImage(twitch);
        githubImage.setImage(github);

        twitchLink.setText("shilkey10");
        githubLink.setText("Github repository");

        twitchLink.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.twitch.tv/shilkey10"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
        githubLink.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/borgCode/RunSearcher"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });

    }

}

