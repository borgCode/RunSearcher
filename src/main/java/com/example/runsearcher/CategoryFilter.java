package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilter implements ChangeListener<Boolean> {

    private final FilterManager manager;
    private final RadioButton categoryButton;
    private final HBox restrictionBox;
    private final List<RadioButton> categories;
    private final String game;
    private final String category;


    public CategoryFilter(FilterManager manager, RadioButton gameButton,
                          RadioButton categoryButton, HBox restrictionBox, ArrayList<RadioButton> categories) {
        this.manager = manager;
        this.categoryButton = categoryButton;
        this.restrictionBox = restrictionBox;
        this.categories = categories;
        game = gameButton.getText().toLowerCase().replaceAll("[’',()]", "");
        category = categoryButton.getText().toLowerCase().replaceAll("[^a-zA-Z0-9]+", "");

    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        if (t1) {
            unSelectCategories(categoryButton);
            restrictionBox.setVisible(true);
        }
        if (aBoolean) {
            restrictionBox.setVisible(false);
        }

        manager.addFilter(run -> {
            if (!categoryButton.isSelected()) {
                return true;
            }
            if ((run.getGame().toLowerCase()
                    .replaceAll("[’',()/+\"]", "").
                    replaceAll("/", "").matches(game + "( classic| remake|: classic|: remake)?")
                    && run.getCategory().toLowerCase().replaceAll("[^a-zA-Z0-9]+", "").
                    matches(category + " *"))) {
                return true;
            } else {
                return false;
            }
        });
    }

    private void unSelectCategories(RadioButton currentButton) {
        for (RadioButton box : categories) {
            if (box != currentButton) {
                box.setSelected(false);
            }
        }
    }
}
