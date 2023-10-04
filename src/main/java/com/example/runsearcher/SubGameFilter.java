package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import java.util.List;

public class SubGameFilter implements ChangeListener<Boolean> {

    private FilteredList<Run> filter;
    private RadioButton currentButton;
    private List<RadioButton> subGameButtons;
    private HBox categoryBox;
    private HBox restrictionBox;
    private String game;

    public SubGameFilter(FilteredList<Run> filter, RadioButton currentButton, List<RadioButton> subGameButtons
            , HBox categoryBox, HBox restrictionBox) {
        this.filter = filter;
        this.currentButton = currentButton;
        this.subGameButtons = subGameButtons;
        this.categoryBox = categoryBox;
        this.restrictionBox = restrictionBox;
        game = currentButton.getText().toLowerCase().replaceAll("[’',()]", "");

    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        if (t1) {
            unSelectAllSubGameButtons(currentButton);
            categoryBox.setVisible(true);
        }
        if (aBoolean) {
            categoryBox.setVisible(false);
            restrictionBox.setVisible(false);
        }
        filter.setPredicate(run -> {
            if (!currentButton.isSelected()) {
                return true;
            }
            if (run.getGame().toLowerCase()
                    .replaceAll("[’',()]", "").replaceAll("/", "").matches(game + "( remake| classic)?")) {
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
