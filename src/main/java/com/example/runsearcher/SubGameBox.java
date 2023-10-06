package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class SubGameBox implements ChangeListener<Boolean> {
    private FilteredList<Run> filter;
    private RadioButton currentButton;
    private List<RadioButton> gameButtons;
    private List<RadioButton> subGameButtons;
    private HBox subGameBox;

    private String game;

    public SubGameBox(FilteredList<Run> filter, List<RadioButton> gameButtons,
                      RadioButton currentButton, List<RadioButton> subGameButtons,
                      HBox subGameBox) {
        this.filter = filter;
        this.currentButton = currentButton;
        this.gameButtons = gameButtons;
        this.subGameButtons = subGameButtons;
        this.subGameBox = subGameBox;
        game = currentButton.getText().toLowerCase().replaceAll("[’',()]", "");


    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        if (t1) {
            unSelectAllGameButtons(currentButton);
            subGameBox.setVisible(true);
        }
        if (aBoolean) {
            for (RadioButton button : subGameButtons) {
                button.setSelected(false);
            }
            subGameBox.setVisible(false);

        }
        filter.setPredicate(run -> {
            if (!currentButton.isSelected()) {
                return true;
            }
            if (run.getGame().toLowerCase()
                    .replaceAll("[’',()]", "").
                    replaceAll("/", "").contains(game)) {
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