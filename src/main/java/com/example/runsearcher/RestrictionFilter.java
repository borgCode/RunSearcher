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
    private StringBuilder restrictionString;
    private RestrictionsMap map;

    public RestrictionFilter(FilteredList<Run> filteredByRestriction, ArrayList<CheckBox> restrictions, RestrictionsMap map) {
        this.filter = filteredByRestriction;
        this.restrictions = restrictions;
        this.restrictionString = new StringBuilder("");
        this.map = map;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        restrictionString.replace(0, restrictionString.length(), "");
        for (CheckBox box : restrictions) {
            if (box.isSelected()) {
                restrictionString.append("(?=.*" + map.getValue(box.getText()) + ").*");
            }
        }


        filter.setPredicate(run -> {
            if (run.getRunName().toLowerCase().
                    replaceAll("[’',()]", "").
                    replaceAll("/", "").matches(restrictionString.toString())) {
                return true;
            } else {
                return false;
            }

        });

    }
}
