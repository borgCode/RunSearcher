package com.example.runsearcher;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML private TextField searchBox;
    @FXML private TableView<Run> tableView;
    @FXML private TableColumn<Run, String> runnerColumn;
    @FXML private TableColumn<Run, String> runColumn;
    @FXML private TableColumn<Run, String> linkColumn;

    public void initialize() {
        runnerColumn.setCellValueFactory(new PropertyValueFactory<>("runner"));
        runColumn.setCellValueFactory(new PropertyValueFactory<>("runName"));
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("runLink"));
        tableView.getItems().setAll((getRuns()));
        filterRuns();

    }

    public ObservableList<Run> getRuns() {
        ObservableList<Run> runs = FXCollections.observableArrayList();
        List<String[]> data;

        try {
            FileReader fileReader = new FileReader("src/runs.csv");
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            data = csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        for (String[] row : data) {
            runs.add(new Run(row[0], row[1], row[2]));
        }


        return runs;

    }

    private void filterRuns() {

        FilteredList<Run> filteredData = new FilteredList<>(getRuns(), b -> true);

        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(run -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String[] values = newValue.toLowerCase().split(" ");
                List<String> wordList = Arrays.asList(values);

                String lowerCaseFilter = newValue.toLowerCase();
                if (run.getRunner().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (wordList.stream().allMatch(Arrays.stream(run.getRunName().toLowerCase().split(" ")).toList()::contains)) {
                    return true;
                } else {
                    return false;
                }

//                if (run.getRunner().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else if (run.getRunName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                } else {
//                    return false;
//                }
            });
        });

        SortedList<Run> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);

    }


}