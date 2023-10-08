package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilter implements ChangeListener<Boolean> {

    private final FilteredList<Run> filter;
    private final RadioButton categoryButton;
    private final HBox restrictionBox;
    private final List<RadioButton> categories;
    private final String game;
    private final String category;


    public CategoryFilter(FilteredList<Run> filter, RadioButton gameButton,
                          RadioButton categoryButton, HBox restrictionBox, ArrayList<RadioButton> categories) {
        this.filter = filter;
        this.categoryButton = categoryButton;
        this.restrictionBox = restrictionBox;
        this.categories = categories;
        game = gameButton.getText().toLowerCase().replaceAll("[’',()]", "");
        category = categoryButton.getText().toLowerCase();

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

        filter.setPredicate(run -> {
            if (!categoryButton.isSelected()) {
                return true;
            }
            if ((run.getGame().toLowerCase()
                    .replaceAll("[’',()/+\"]", "").
                    replaceAll("/", "").matches(game + "( classic| remake|: classic|: remake)?")
                    && run.getCategory().toLowerCase().replaceAll("[’',()/+\"]", "").
                    matches(category + ".*"))) {
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
