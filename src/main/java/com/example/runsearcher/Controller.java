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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private TextField searchBox;
    @FXML
    private CheckBox demonsSoulsCheckBox;
    @FXML
    private CheckBox darkSoulsCheckBox;
    @FXML
    private CheckBox darkSoulsTwoCheckBox;
    @FXML
    private CheckBox darkSoulsThreeCheckBox;
    @FXML
    private CheckBox bloodborneCheckBox;
    @FXML
    private CheckBox sekiroCheckBox;
    @FXML
    private CheckBox eldenRingCheckBox;
    @FXML
    private CheckBox residentEvilCheckBox;
    @FXML
    private CheckBox crashCheckBox;
    @FXML
    private CheckBox dishonoredCheckBox;
    @FXML
    private CheckBox zeldaCheckBox;
    @FXML
    private CheckBox cupheadCheckBox;
    @FXML
    private CheckBox hollowKnightCheckBox;
    @FXML
    private CheckBox hadesCheckBox;
    @FXML
    private CheckBox celesteCheckBox;
    @FXML
    private CheckBox blasphemousCheckBox;
    @FXML
    private CheckBox multipleCheckBox;
    @FXML
    private TableView<Run> tableView;
    @FXML
    private TableColumn<Run, String> runnerColumn;
    @FXML
    private TableColumn<Run, String> runColumn;
    @FXML
    private TableColumn<Run, String> linkColumn;

    public void initialize() {
        runnerColumn.setCellValueFactory(new PropertyValueFactory<>("runner"));
        runColumn.setCellValueFactory(new PropertyValueFactory<>("runName"));
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("runLink"));
        tableView.getItems().setAll((getRuns()));
        filterRuns();

        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.C && e.isControlDown()) {
                int row = tableView.getSelectionModel().getSelectedIndex();
                Run run = tableView.getItems().get(row);
                final ClipboardContent clipboardContent = new ClipboardContent();
                if (tableView.getSelectionModel().isSelected(row, runnerColumn)) {
                    clipboardContent.putString(run.getRunner());
                } else if (tableView.getSelectionModel().isSelected(row, runColumn)) {
                    clipboardContent.putString(run.getRunName());
                } else if (tableView.getSelectionModel().isSelected(row, linkColumn)) {
                    clipboardContent.putString(run.getRunLink());
                }
                Clipboard.getSystemClipboard().setContent(clipboardContent);
            }
        });


    }


    public void handleUserSelection(ActionEvent event) {
        tableView.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN), new Runnable() {
            @Override
            public void run() {
                int selectedCell = tableView.getSelectionModel().getSelectedIndex();
                Run data = tableView.getItems().get(selectedCell);
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                if (tableView.getSelectionModel().isSelected(selectedCell)) {
                    System.out.println(data.getRunLink());
                    content.putString(data.getRunLink());
                } else {
                    System.out.println(data.getRunner());
                    content.putString(data.getRunLink());
                }
            }
        });
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


        FilteredList<Run> filteredByCheckBox = new FilteredList<>(getRuns(), b -> true);
        FilteredList<Run> filteredByText = new FilteredList<>(filteredByCheckBox, b -> true);


        demonsSoulsCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(demonsSoulsCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!demonsSoulsCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("demons souls")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        darkSoulsCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(darkSoulsCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!darkSoulsCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .matches(".*dark souls(?! ii| trilogy).*")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        darkSoulsTwoCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(darkSoulsTwoCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!darkSoulsTwoCheckBox.isSelected()) {
                        return true;
                    }

                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .matches(".*dark souls ii(?!i).*")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        darkSoulsThreeCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(darkSoulsThreeCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!darkSoulsThreeCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .matches(".*dark souls iii.*")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        bloodborneCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(bloodborneCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!bloodborneCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("bloodborne")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        sekiroCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(sekiroCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!sekiroCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("sekiro")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        eldenRingCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(eldenRingCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!eldenRingCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("elden ring")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        residentEvilCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(residentEvilCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!residentEvilCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("resident evil")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        crashCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(crashCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!crashCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("crash")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        dishonoredCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(dishonoredCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!dishonoredCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("dishonored")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        zeldaCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(zeldaCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!zeldaCheckBox.isSelected()) {
                        return true;
                    }

                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("zelda")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        cupheadCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(cupheadCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!cupheadCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("cuphead")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        hollowKnightCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(hollowKnightCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!hollowKnightCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("hollow knight")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        hadesCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(hadesCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!hadesCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("hades")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        celesteCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(celesteCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!celesteCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("celeste")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });
        blasphemousCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(blasphemousCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!blasphemousCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .contains("blasphemous")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        multipleCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    unSelectAll(multipleCheckBox);
                }
                filteredByCheckBox.setPredicate(run -> {
                    if (!multipleCheckBox.isSelected()) {
                        return true;
                    }
                    if (run.getRunName().toLowerCase()
                            .replaceAll("’", "").replaceAll("'", "")
                            .matches(".*(trilogy|soulsborne|marathon).*")) {
                        return true;
                    } else {
                        return false;
                    }

                });
            }
        });

        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredByText.setPredicate(run -> {
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

        SortedList<Run> sortedData = new SortedList<>(filteredByText);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void unSelectAll(CheckBox checkBox) {
        for (CheckBox box : Arrays.asList(demonsSoulsCheckBox, darkSoulsCheckBox, darkSoulsTwoCheckBox,
                darkSoulsThreeCheckBox, sekiroCheckBox, eldenRingCheckBox, bloodborneCheckBox,
                residentEvilCheckBox, crashCheckBox, dishonoredCheckBox, celesteCheckBox,
                hollowKnightCheckBox, zeldaCheckBox, blasphemousCheckBox, multipleCheckBox,
                hadesCheckBox, cupheadCheckBox)) {
            if (box != checkBox) {
                box.setSelected(false);
            }
        }
    }
}