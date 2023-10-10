package com.example.runsearcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchFilter implements ChangeListener<String> {

    private final FilterManager manager;

    public SearchFilter(FilterManager manager) {
        this.manager = manager;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

        if (newValue != null && !newValue.isEmpty()) {
            Predicate<Run> textFilterPredicate = createTextFilterPredicate(newValue);
            manager.setTextFilterPredicate(textFilterPredicate);
        } else {
            manager.setTextFilterPredicate(run -> true);
        }

    }


    private Predicate<Run> createTextFilterPredicate(String newValue) {
        return run -> {
            String[] values = newValue.toLowerCase().split(" ");
            List<String> wordList = Arrays.stream(values)
                    .map(s -> s.replaceAll("[’',()]", "").replaceAll("/", " "))
                    .toList();
            String lowerCaseFilter = newValue.toLowerCase().replaceAll("’", "").replaceAll("'", "");

            if (run.getRunner().toLowerCase()
                    .replaceAll("’", "").replaceAll("'", "")
                    .contains(lowerCaseFilter)) {
                return true;
            } else if (wordList.stream().allMatch(Arrays.stream(run.getGame().toLowerCase()
                    .replaceAll("[’',()]", "")
                    .replaceAll("/", " ")
                    .split(" ")).toList()::contains)) {
                return true;
            } else if (run.getCategory().toLowerCase()
                    .replaceAll("’", "").replaceAll("'", "")
                    .contains(lowerCaseFilter)) {
                return true;
            } else if (wordList.stream().allMatch(Arrays.stream(run.getRunName().toLowerCase()
                    .replaceAll("[’',()]", "")
                    .replaceAll("/", " ")
                    .split(" ")).toList()::contains)) {
                return true;
            } else {
                return false;
            }
        };
    }
}
