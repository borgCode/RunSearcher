package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.controlsfx.control.ToggleSwitch;

public class WorldFirstFilter implements ChangeListener<Boolean> {

    private final FilterManager manager;
    private final ToggleSwitch toggleSwitch;


    public WorldFirstFilter(FilterManager manager, ToggleSwitch toggleSwitch) {
        this.manager = manager;
        this.toggleSwitch = toggleSwitch;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

        manager.addFilter(run -> {
            if (!toggleSwitch.isSelected()) {
                return true;
            }
            if (run.getRunName().toLowerCase().replaceAll("[^a-zA-Z0-9]+", "").
                    matches(".*(worldsfirst|worldfirst|wf)")) {
                return true;
            } else {
                return false;
            }
        });

    }
}
