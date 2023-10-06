package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class GameFilter implements ChangeListener<Boolean> {

    private final FilteredList<Run> filter;
    private final RadioButton currentButton;
    private final List<RadioButton> gameButtons;
    private final HBox categoryBox;
    private final HBox restrictionBox;
    private final String game;
    private final ArrayList<RadioButton> categories;
    private final FilteredList<Run> restrictionFilter;
    private final ArrayList<CheckBox> restrictions;


    public GameFilter(FilteredList<Run> filter, RadioButton currentButton, List<RadioButton> gameButtons
            , HBox categoryBox, HBox restrictionBox, ArrayList<RadioButton> categories,
                      FilteredList<Run> restrictionFilter, ArrayList<CheckBox> restrictions) {
        this.filter = filter;
        this.currentButton = currentButton;
        this.gameButtons = gameButtons;
        this.categoryBox = categoryBox;
        this.restrictionBox = restrictionBox;
        this.categories = categories;
        this.restrictionFilter = restrictionFilter;
        this.restrictions = restrictions;
        game = currentButton.getText().toLowerCase().replaceAll("[’',()]", "");
    }
    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        if (t1) {
            unSelectAllGameButtons(currentButton);
            categoryBox.setVisible(true);
        }
        if (aBoolean) {
            categoryBox.setVisible(false);
            restrictionBox.setVisible(false);
            for (RadioButton button: categories) {
                button.setSelected(false);
            }
            restrictionFilter.setPredicate(run -> true);
            for (CheckBox box : restrictions) {
                box.setSelected(false);
            }

        }
        filter.setPredicate(run -> {
            if (!currentButton.isSelected()) {
                return true;
            }
            if (run.getGame().toLowerCase()
                            .replaceAll("[’',()]", "").
                    replaceAll("/", "").matches(game + "( classic| remake|: classic|: remake)?")) {
                return true;
            } else {
                return false;
            }
        });

    }
    private void unSelectAllGameButtons(RadioButton currentButton) {
        for (RadioButton box : gameButtons) {
            if (box != currentButton) {
                box.setSelected(false);
            }
        }
    }
}
