package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.Collections;
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
                activeFilters.add(new RestrictionFilterPredicate(Collections.singletonList(checkBox), map));
            }
        }

        manager.setActiveFilters(activeFilters);



    }
}

class RestrictionFilterPredicate implements Predicate<Run> {
    private final List<CheckBox> selectedBoxes;
    private final RestrictionsMap map;

    public RestrictionFilterPredicate(List<CheckBox> selectedBoxes, RestrictionsMap map) {
        this.selectedBoxes = selectedBoxes;
        this.map = map;
    }

    @Override
    public boolean test(Run run) {
        StringBuilder restrictionString = new StringBuilder();

        if (selectedBoxes.isEmpty()) {
            return true;
        }


        List<CheckBox> selectedBoxesCopy = new ArrayList<>(selectedBoxes);

        for (CheckBox box : selectedBoxesCopy) {
            restrictionString.append("(?=.*" + map.getValue(box.getText()) + ").*");
        }



        String runName = run.getRunName().toLowerCase()
                .replaceAll("[’',()\"]", "")
                .replaceAll("/", "");

        System.out.println(runName);

        return runName.matches(restrictionString.toString());
    }
}
