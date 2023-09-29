package com.example.runsearcher;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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
    @FXML private CheckBox demonsSoulsCheckBox;
    @FXML private CheckBox darkSoulsCheckBox;
    @FXML private CheckBox darkSoulsTwoCheckBox;
    @FXML private CheckBox darkSoulsThreeCheckBox;
    @FXML private CheckBox bloodborneCheckBox;
    @FXML private CheckBox sekiroCheckBox;
    @FXML private CheckBox eldenRingCheckBox;
    @FXML private CheckBox residentEvilCheckBox;
    @FXML private CheckBox crashCheckBox;
    @FXML private CheckBox dishonoredCheckBox;
    @FXML private CheckBox zeldaCheckBox;
    @FXML private CheckBox cupheadCheckBox;
    @FXML private CheckBox hollowKnightCheckBox;
    @FXML private CheckBox hadesCheckBox;
    @FXML private CheckBox celesteCheckBox;
    @FXML private CheckBox blasphemousCheckBox;
    @FXML private CheckBox multipleCheckBox;
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


        demonsSoulsCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                filteredData.setPredicate(run -> {
                    if (demonsSoulsCheckBox.isSelected() == false) {
                        return true;
                    }
                    String filter = "demons souls";
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains(filter)) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(run -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String[] values = newValue.toLowerCase().split(" ");
                List<String> wordList = Arrays.stream(values)
                        .map(s -> s.replaceAll("’", "").replaceAll("'", ""))
                        .toList();

                if (wordList.stream().allMatch(Arrays.stream(run.getRunner().toLowerCase()
                        .replaceAll("’", "").replaceAll("'", "")
                        .split(" ")).toList()::contains)) {
                    return true;
                } else if (wordList.stream().allMatch(Arrays.stream(run.getRunName().toLowerCase()
                        .replaceAll("’", "").replaceAll("'", "")
                        .split(" ")).toList()::contains)) {
                    return true;
                } else {
                    return false;
                }

            });
        });


        SortedList<Run> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(sortedData);

    }

    public void change



}