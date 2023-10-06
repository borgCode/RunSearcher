package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class SubGameFilter implements ChangeListener<Boolean> {

    private final FilteredList<Run> filter;
    private final RadioButton currentButton;
    private final List<RadioButton> subGameButtons;
    private final HBox categoryBox;
    private final HBox restrictionBox;
    private final String game;
    private final ArrayList<RadioButton> categories;
    private final FilteredList<Run> restrictionFilter;
    private final ArrayList<CheckBox> restrictions;

    public SubGameFilter(FilteredList<Run> filter, RadioButton currentButton,
                         List<RadioButton> subGameButtons, HBox categoryBox,
                         HBox restrictionBox, ArrayList<RadioButton> categories,
                         FilteredList<Run> restrictionFilter, ArrayList<CheckBox> restrictions) {
        this.filter = filter;
        this.currentButton = currentButton;
        this.subGameButtons = subGameButtons;
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
            unSelectAllSubGameButtons(currentButton);
            categoryBox.setVisible(true);
        }
        if (aBoolean) {
            for (RadioButton button : categories) {
                button.setSelected(false);
            }
            categoryBox.setVisible(false);
            restrictionBox.setVisible(false);

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
                    replaceAll("/", "").matches(game + "( remake| classic|: classic|: remake)?")) {
                return true;
            } else {
                return false;
            }
        });

    }


    private void unSelectAllSubGameButtons(RadioButton currentButton) {
        for (RadioButton box : subGameButtons) {
            if (box != currentButton) {
                box.setSelected(false);
            }
        }
    }
}
