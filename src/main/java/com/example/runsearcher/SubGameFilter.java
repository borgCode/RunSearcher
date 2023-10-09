package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SubGameFilter implements ChangeListener<Boolean> {

    private final FilterManager manager;
    private final RadioButton currentButton;
    private final List<RadioButton> subGameButtons;
    private final HBox categoryBox;
    private final HBox restrictionBox;
    private final String game;
    private final ArrayList<RadioButton> categories;
    private final ArrayList<CheckBox> restrictions;

    public SubGameFilter(FilterManager manager, RadioButton currentButton,
                         List<RadioButton> subGameButtons, HBox categoryBox,
                         HBox restrictionBox, ArrayList<RadioButton> categories,
                         ArrayList<CheckBox> restrictions) {
        this.manager = manager;
        this.currentButton = currentButton;
        this.subGameButtons = subGameButtons;
        this.categoryBox = categoryBox;
        this.restrictionBox = restrictionBox;
        this.categories = categories;
        this.restrictions = restrictions;
        game = currentButton.getText().toLowerCase().replaceAll("[’',()]", "");

    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        Predicate<Run> predicate = run -> {
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
        };

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

            manager.removeFilter(predicate);
            for (CheckBox box : restrictions) {
                box.setSelected(false);
            }
        }
        manager.addFilter(predicate);

    }


    private void unSelectAllSubGameButtons(RadioButton currentButton) {
        for (RadioButton box : subGameButtons) {
            if (box != currentButton) {
                box.setSelected(false);
            }
        }
    }
}
