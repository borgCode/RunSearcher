package com.example.runsearcher;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class FilterManager {
    private FilteredList<Run> filteredData;
    private SortedList<Run> sortedData;
    private List<Predicate<Run>> predicateList;
    private List<Predicate<Run>> activeFilters;
    private Predicate<Run> textFilterPredicate = run -> true;



    public FilterManager(ObservableList<Run> data, TableView<Run> tableView) {
        filteredData = new FilteredList<>(data);
        sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        predicateList = new ArrayList<>();
        activeFilters = new ArrayList<>();
    }

    public void addFilter(Predicate<Run> filter) {
        predicateList.add(filter);
        applyFilters();
    }

    public void removeFilter(Predicate<Run> filter) {
        predicateList.remove(filter);
        applyFilters();
    }

    public void setActiveFilters(List<Predicate<Run>> activeFilters) {
        this.activeFilters = activeFilters;
        applyFilters();
    }

    public void setTextFilterPredicate(Predicate<Run> textFilterPredicate) {
        this.textFilterPredicate = textFilterPredicate;
        applyFilters();

    }

    private void applyFilters() {
        Predicate<Run> combinedPredicate = predicateList.stream().reduce(Predicate::and).orElse(run -> true);
        if (!activeFilters.isEmpty()) {
            Predicate<Run> finalPredicate = activeFilters.stream().reduce(combinedPredicate, Predicate::and)
                    .and(textFilterPredicate);
            filteredData.setPredicate(finalPredicate);
        } else {
            Predicate<Run> finalPredicate = combinedPredicate.and(textFilterPredicate);
            filteredData.setPredicate(finalPredicate);
        }

    }

    public SortedList<Run> getSortedData() {
        return sortedData;
    }


}
