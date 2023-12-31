package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import java.util.List;

public class SubGameBox implements ChangeListener<Boolean> {
    private final FilterManager manager;
    private final RadioButton currentButton;
    private final List<RadioButton> gameButtons;
    private final List<RadioButton> subGameButtons;
    private final HBox subGameBox;
    private final String game;

    public SubGameBox(FilterManager manager, List<RadioButton> gameButtons,
                      RadioButton currentButton, List<RadioButton> subGameButtons,
                      HBox subGameBox) {
        this.manager = manager;
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
        manager.addFilter(run -> {
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
