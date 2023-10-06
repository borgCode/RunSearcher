package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class RestrictionFilter implements EventHandler<ActionEvent> {

    private FilteredList<Run> filter;
    private ArrayList<CheckBox> restrictions;
    private RestrictionsMap map;

    public RestrictionFilter(FilteredList<Run> filteredByRestriction, ArrayList<CheckBox> restrictions, RestrictionsMap map) {
        this.filter = filteredByRestriction;
        this.restrictions = restrictions;

        this.map = map;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<CheckBox> selectedBoxes = new ArrayList<>();
        StringBuilder restrictionString = new StringBuilder();

        for (CheckBox box : restrictions) {
            if (box.isSelected()) {
                selectedBoxes.add(box);
            }
        }

        if (selectedBoxes.isEmpty()) {
            filter.setPredicate( run -> true);
            return;
        }

        for (CheckBox box: selectedBoxes) {
            restrictionString.append("(?=.*" + map.getValue(box.getText()) + ").*");
        }

        System.out.println(restrictionString);


        filter.setPredicate(run -> {

            if (run.getRunName().toLowerCase().
                    replaceAll("[’',()\"]", "").
                    replaceAll("/", "").matches(restrictionString.toString())) {
                return true;
            } else {
                return false;
            }

        });

    }
}
