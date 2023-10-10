package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RestrictionFilter implements ChangeListener<Boolean> {

    private final FilterManager manager;
    private final ArrayList<CheckBox> restrictions;
    private final RestrictionsMap map;

    public RestrictionFilter(FilterManager manager, ArrayList<CheckBox> restrictions, RestrictionsMap map) {
        this.manager = manager;
        this.restrictions = restrictions;
        this.map = map;
    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {



        List<Predicate<Run>> activeFilters = new ArrayList<>();

        for (CheckBox checkBox : restrictions) {
            if (checkBox.isSelected()) {
                activeFilters.add(new RestrictionFilterPredicate(checkBox, map));
            }
        }

        manager.setActiveFilters(activeFilters);
    }
}

class RestrictionFilterPredicate implements Predicate<Run> {
    private final CheckBox box;
    private final RestrictionsMap map;

    public RestrictionFilterPredicate(CheckBox box, RestrictionsMap map) {
        this.box = box;
        this.map = map;
    }

    @Override
    public boolean test(Run run) {

        String restrictionString = "(?=.*" + map.getValue(box.getText()) + ").*";


        String runName = run.getRunName().toLowerCase()
                .replaceAll("[’',()\"]", "")
                .replaceAll("/", "");
        return runName.matches(restrictionString);
    }
}
