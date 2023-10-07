package com.example.runsearcher;

import javafx.beans.property.SimpleStringProperty;

public class Run {
    private String runner;
    private String game;
    private String category;
    private String runName;
    private SimpleStringProperty runLink;

    public Run(String runner, String game, String category, String runName, String runLink) {
        this.runner = runner;
        this.game = game;
        this.category = category;
        this.runName = runName;
        this.runLink = new SimpleStringProperty(runLink);
    }

    public String getRunner() {
        return runner;
    }

    public void setRunner(String runner) {
        this.runner = runner;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRunName() {
        return runName;
    }

    public void setRunName(String runName) {
        this.runName = runName;
    }

    public String getRunLink() {
        return runLink.get();
    }

    public SimpleStringProperty runLinkProperty() {
        return runLink;
    }
}
//
//    public String getRunLink() {
//        return runLink;
//    }
//
//    public void setRunLink(String runLink) {
//        this.runLink = runLink;
//    }
//}
