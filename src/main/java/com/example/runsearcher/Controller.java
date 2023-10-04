package com.example.runsearcher;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private TextField searchBox;
    @FXML
    private RadioButton demonsSoulsRadioButton;
    @FXML
    private RadioButton darkSoulsRadioButton;
    @FXML
    private RadioButton darkSoulsTwoRadioButton;
    @FXML
    private RadioButton darkSoulsThreeRadioButton;
    @FXML
    private RadioButton bloodborneRadioButton;
    @FXML
    private RadioButton sekiroRadioButton;
    @FXML
    private RadioButton eldenRingRadioButton;
    @FXML
    private RadioButton residentEvilRadioButton;
    @FXML
    private RadioButton crashRadioButton;
    @FXML
    private RadioButton dishonoredRadioButton;
    @FXML
    private RadioButton zeldaRadioButton;
    @FXML
    private RadioButton cupheadRadioButton;
    @FXML
    private RadioButton hollowKnightRadioButton;
    @FXML
    private RadioButton hadesRadioButton;
    @FXML
    private RadioButton celesteRadioButton;
    @FXML
    private RadioButton blasphemousRadioButton;
    @FXML
    private RadioButton multipleRadioButton;
    @FXML
    private HBox demonsSoulsCategoryBox;
    @FXML
    private RadioButton demonsSoulsAny;
    @FXML
    private RadioButton demonsSoulsAB;
    @FXML
    private RadioButton demonsSoulsAA;
    @FXML
    private HBox demonsSoulsRestrictionsBox;
    @FXML
    private HBox darkSoulsCategoryBox;
    @FXML
    private RadioButton darkSoulsAny;
    @FXML
    RadioButton darkSoulsAMGB;
    @FXML
    private RadioButton darkSoulsAB;
    @FXML
    private RadioButton darkSoulsAA;
    @FXML
    private HBox darkSoulsRestrictionsBox;
    @FXML
    private HBox darkSoulsTwoCategoryBox;
    @FXML
    private RadioButton darkSoulsTwoAny;
    @FXML
    private RadioButton darkSoulsTwoAMGB;
    @FXML
    private RadioButton darkSoulsTwoAB;
    @FXML
    private RadioButton darkSoulsTwoAA;
    @FXML
    private HBox darkSoulsTwoRestrictionsBox;
    @FXML
    private HBox darkSoulsThreeCategoryBox;
    @FXML
    private RadioButton darkSoulsThreeAny;
    @FXML
    private RadioButton darkSoulsThreeAMGB;
    @FXML
    private RadioButton darkSoulsThreeAB;
    @FXML
    private RadioButton darkSoulsThreeAA;
    @FXML
    private HBox darkSoulsThreeRestrictionsBox;
    @FXML
    private HBox bloodborneCategoryBox;
    @FXML
    private RadioButton bloodborneAny;
    @FXML
    private RadioButton bloodborneAMGB;
    @FXML
    private RadioButton bloodborneAB;
    @FXML
    private RadioButton bloodborneABC;
    @FXML
    private RadioButton bloodborneAA;
    @FXML
    private HBox bloodborneRestrictionsBox;
    @FXML
    private HBox sekiroCategoryBox;
    @FXML
    private RadioButton sekiroShura;
    @FXML
    private RadioButton sekiroIS;
    @FXML private RadioButton sekiroReturn;
    @FXML
    private RadioButton sekiroPuri;
    @FXML
    private RadioButton sekiroAM;
    @FXML
    private RadioButton sekiroABM;
    @FXML
    private RadioButton sekiroABMB;
    @FXML
    private RadioButton sekiroMJ;
    @FXML
    private RadioButton sekiroAMG;
    @FXML
    private RadioButton sekiroAA;
    @FXML
    private RadioButton sekiroAllEnemy;
    @FXML
    private HBox sekiroRestrictionsBox;
    @FXML
    private HBox eldenRingCategoryBox;
    @FXML
    private RadioButton eldenRingAny;
    @FXML
    private RadioButton eldenRingAGR;
    @FXML
    private RadioButton eldenRingAR;
    @FXML
    private RadioButton eldenRingAB;
    @FXML
    private RadioButton eldenRingAA;
    @FXML
    private HBox eldenRingRestrictionsBox;

    @FXML private HBox residentEvilSubGameBox;
    @FXML private RadioButton residentEvil0Button;
    @FXML private HBox residentEvil0CategoryBox;
    @FXML private HBox residentEvil0RestrictionsBox;
    @FXML private RadioButton residentEvil0Any;
    @FXML private RadioButton residentEvil0HardAny;
    @FXML private RadioButton residentEvil0ExtraModes;
    @FXML private RadioButton residentEvil0NGPlus;

    @FXML private RadioButton residentEvil1Button;
    @FXML private RadioButton residentEvil1Normal;
    @FXML private RadioButton residentEvil1Hard;
    @FXML private RadioButton residentEvil1RealSurvivor;
    @FXML private RadioButton residentEvil1InvisibleEnemy;
    @FXML private RadioButton residentEvil1Original;
    @FXML private RadioButton residentEvil1Arrange;
    @FXML private HBox residentEvil1CategoryBox;
    @FXML private HBox residentEvil1RestrictionsBox;

    @FXML private RadioButton residentEvil2Button;
    @FXML private HBox residentEvil2CategoryBox;
    @FXML private HBox residentEvil2RestrictionsBox;
    @FXML private RadioButton residentEvil2Any;
    @FXML private RadioButton residentEvil2Hard;
    @FXML private RadioButton residentEvil2True;
    @FXML private RadioButton residentEvil2AllScenarios;
    @FXML private RadioButton residentEvil2ExtraMode;
    @FXML private RadioButton residentEvil2Normal;
    @FXML private RadioButton residentEvil3Button;
    @FXML private HBox residentEvil3CategoryBox;
    @FXML private HBox residentEvil3RestrictionsBox;

    @FXML private RadioButton residentEvil3Hard;
    @FXML private RadioButton residentEvil3Nightmare;
    @FXML private RadioButton residentEvil3Inferno;
    @FXML private RadioButton residentEvil3Nemesis;
    @FXML private RadioButton residentEvil3AllBosses;

    @FXML private RadioButton residentEvil4Button;
    @FXML private HBox residentEvil4CategoryBox;
    @FXML private HBox residentEvil4RestrictionsBox;
    @FXML private RadioButton residentEvil4Pro;
    @FXML private RadioButton residentEvil4Extra;
    @FXML private RadioButton residentEvil4NoMerchant;

    @FXML private RadioButton residentEvil7Button;
    @FXML private HBox residentEvil7CategoryBox;
    @FXML private HBox residentEvil7RestrictionsBox;
    @FXML private RadioButton residentEvil7Normal;
    @FXML private RadioButton residentEvil7Madhouse;
    @FXML private RadioButton residentEvil7Extra;
    @FXML private RadioButton residentEvilVillageButton;
    @FXML private HBox residentEvilVillageCategoryBox;
    @FXML private HBox residentEvilVillageRestrictionsBox;
    @FXML private RadioButton residentEvilVillageHard;
    @FXML private RadioButton residentEvilVillageVillage;
    @FXML private RadioButton residentEvilVillageDuke;
    @FXML private RadioButton residentEvilVillageExtra;
    @FXML private RadioButton residentEvilSurvivorButton;
    @FXML private HBox residentEvilSurvivorCategoryBox;
    @FXML private HBox residentEvilSurvivorRestrictionsBox;
    @FXML private RadioButton residentEvilSurvivorAny;
    @FXML private RadioButton residentEvilSurvivorS;
    @FXML private RadioButton crash1Button;
    @FXML private RadioButton crashTwoButton;
    @FXML private RadioButton crashThreeButton;
    @FXML private RadioButton crashFourButton;
    @FXML private HBox crashSubGameBox;
    @FXML private HBox crashCategoryBox;
    @FXML private HBox crashRestrictionsBox;
    @FXML private RadioButton crashAny;
    @FXML private RadioButton crashSecretEnding;
    @FXML private RadioButton crashAllLevels;
    @FXML private RadioButton crashAllGems;
    @FXML private RadioButton crash105;
    @FXML private HBox crashTwoCategoryBox;
    @FXML private HBox crashTwoRestrictionsBox;
    @FXML private RadioButton crashTwoAny;
    @FXML private RadioButton crashTwoAllLevels;
    @FXML private RadioButton crashTwoAllGems;
    @FXML private RadioButton crashTwo102;
    @FXML private HBox crashThreeCategoryBox;
    @FXML private HBox crashThreeRestrictionsBox;

    @FXML private RadioButton crashThreeAny;
    @FXML private RadioButton crashThree108;
    @FXML private HBox crashFourCategoryBox;
    @FXML private HBox crashFourRestrictionsBox;

    @FXML private RadioButton crashFourAny;
    @FXML private RadioButton crashFourAllTimelines;
    @FXML private RadioButton crashFourAllClearGems;
    @FXML private RadioButton crashFour106;
    @FXML private HBox dishonoredSubGameBox;
    @FXML private HBox dishonoredCategoryBox;
    @FXML private HBox dishonoredRestrictionsBox;

    @FXML private RadioButton dishonoredOneButton;
    @FXML private RadioButton dishonoredTwoButton;
    @FXML private RadioButton dishonoredDotoButton;
    @FXML private RadioButton dishonoredAny;
    @FXML private RadioButton dishonoredDLC;
    @FXML private RadioButton dishonoredAllMissions;
    @FXML private RadioButton dishonoredAllCollectibles;
    @FXML private HBox dishonoredTwoCategoryBox;
    @FXML private HBox dishonoredTwoRestrictionsBox;

    @FXML private RadioButton dishonoredTwoAny;
    @FXML private RadioButton dishonoredTwoAllCollectibles;
    @FXML private HBox dishonoredDotoCategoryBox;
    @FXML private HBox dishonoredDotoRestrictionsBox;

    @FXML private RadioButton dishonoredDotoAny;
    @FXML private RadioButton dishonoredDotoAllContracts;
    @FXML private RadioButton dishonoredDotoAllCollectibles;
    @FXML private RadioButton dishonoredDotoAA;
    @FXML private HBox zeldaCategoryBox;
    @FXML private HBox zeldaRestrictionsBox;
    @FXML private HBox zeldaEvilSubGameBox;
    @FXML private HBox cupheadCategoryBox;
    @FXML private HBox cupheadRestrictionsBox;
    @FXML private HBox hollowKnightCategoryBox;
    @FXML private HBox hollowKnightRestrictionsBox;
    @FXML private HBox celesteCategoryBox;
    @FXML private HBox celesteRestrictionsBox;
    @FXML private HBox hadesCategoryBox;
    @FXML private HBox hadesRestrictionsBox;
    @FXML private HBox blasphemousCategoryBox;
    @FXML private HBox blasphemousRestrictionsBox;
    @FXML private HBox multipleCategoryBox;
    @FXML private HBox multipleRestrictionsBox;

    @FXML
    private TableView<Run> tableView;
    @FXML
    private TableColumn<Run, String> runnerColumn;
    @FXML
    private TableColumn<Run, String> gameColumn;
    @FXML
    private TableColumn<Run, String> categoryColumn;
    @FXML
    private TableColumn<Run, String> runColumn;
    @FXML
    private TableColumn<Run, String> linkColumn;
    private List<RadioButton> gameButtons;



    public void initialize() {
        runnerColumn.setCellValueFactory(new PropertyValueFactory<>("runner"));
        gameColumn.setCellValueFactory(new PropertyValueFactory<>("game"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        runColumn.setCellValueFactory(new PropertyValueFactory<>("runName"));
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("runLink"));
        tableView.getItems().setAll((getRuns()));

        gameButtons = new ArrayList<>(List.of(demonsSoulsRadioButton, darkSoulsRadioButton,
                darkSoulsTwoRadioButton, darkSoulsThreeRadioButton, bloodborneRadioButton,
                sekiroRadioButton, eldenRingRadioButton, residentEvilRadioButton,
                crashRadioButton, dishonoredRadioButton, zeldaRadioButton,
                cupheadRadioButton, hollowKnightRadioButton, hadesRadioButton,
                celesteRadioButton, blasphemousRadioButton, multipleRadioButton));




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

        filterRuns();


    }


    public void handleUserSelection(ActionEvent event) {
        tableView.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN), new Runnable() {
            @Override
            public void run() {
                int selectedCell = tableView.getSelectionModel().getSelectedIndex();
                Run data = tableView.getItems().get(selectedCell);
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

        try (InputStream in = getClass().getResourceAsStream("/runs.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            data = csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        for (String[] row : data) {
            runs.add(new Run(row[0], row[1], row[2], row[3], row[4]));
        }


        return runs;

    }

    private void filterRuns() {


        FilteredList<Run> filteredByGame = new FilteredList<>(getRuns(), b -> true);
        FilteredList<Run> filteredByText = new FilteredList<>(filteredByGame, b -> true);


        //Game filters

        demonsSoulsRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, demonsSoulsRadioButton, gameButtons,
                        demonsSoulsCategoryBox, demonsSoulsRestrictionsBox));

        darkSoulsRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, darkSoulsRadioButton, gameButtons,
                        darkSoulsCategoryBox, darkSoulsRestrictionsBox));

        darkSoulsTwoRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, darkSoulsTwoRadioButton, gameButtons,
                        darkSoulsTwoCategoryBox, darkSoulsTwoRestrictionsBox));

        darkSoulsThreeRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, darkSoulsThreeRadioButton, gameButtons,
                        darkSoulsThreeCategoryBox, darkSoulsThreeRestrictionsBox));

        bloodborneRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, bloodborneRadioButton, gameButtons,
                        bloodborneCategoryBox, bloodborneRestrictionsBox));
        sekiroRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, sekiroRadioButton, gameButtons,
                        sekiroCategoryBox, sekiroRestrictionsBox));
        eldenRingRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, eldenRingRadioButton, gameButtons,
                        eldenRingCategoryBox, eldenRingRestrictionsBox));

        ArrayList<RadioButton> residentEvilSubGames = new ArrayList<>(
                List.of(residentEvil0Button, residentEvil1Button, residentEvil2Button,
                        residentEvil3Button, residentEvil4Button, residentEvil7Button,
                        residentEvilVillageButton, residentEvilSurvivorButton));
        residentEvilRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, residentEvilRadioButton, residentEvilSubGames, residentEvilSubGameBox));

        residentEvil0Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil0Button,
                        residentEvilSubGames, residentEvil0CategoryBox, residentEvil0RestrictionsBox));
        residentEvil1Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil1Button,
                        residentEvilSubGames, residentEvil1CategoryBox, residentEvil1RestrictionsBox));
        residentEvil2Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil2Button,
                        residentEvilSubGames, residentEvil2CategoryBox, residentEvil2RestrictionsBox));
        residentEvil3Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil3Button,
                        residentEvilSubGames, residentEvil3CategoryBox, residentEvil3RestrictionsBox));
        residentEvil4Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil4Button,
                        residentEvilSubGames, residentEvil4CategoryBox, residentEvil4RestrictionsBox));
        residentEvil7Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil7Button,
                        residentEvilSubGames, residentEvil7CategoryBox, residentEvil7RestrictionsBox));
        residentEvilVillageButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvilVillageButton,
                        residentEvilSubGames, residentEvilVillageCategoryBox, residentEvilVillageRestrictionsBox));
        residentEvilSurvivorButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvilSurvivorButton,
                        residentEvilSubGames, residentEvilSurvivorCategoryBox, residentEvilSurvivorRestrictionsBox));
        ArrayList<RadioButton> crashSubGames = new ArrayList<>(
                List.of(crash1Button, crashTwoButton, crashThreeButton, crashFourButton));

        crashRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, crashRadioButton, crashSubGames, crashSubGameBox));
        crash1Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crash1Button, crashSubGames, crashCategoryBox, crashRestrictionsBox)
        );
        crashTwoButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crashTwoButton, crashSubGames, crashTwoCategoryBox, crashTwoRestrictionsBox)
        );
        crashThreeButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crashThreeButton, crashSubGames, crashThreeCategoryBox, crashThreeRestrictionsBox)
        );
        crashFourButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crashFourButton, crashSubGames, crashFourCategoryBox, crashFourRestrictionsBox)
        );

        ArrayList<RadioButton> dishonoredSubGames = new ArrayList<>(
                List.of(dishonoredOneButton, dishonoredTwoButton, dishonoredDotoButton));

        dishonoredRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, dishonoredRadioButton, dishonoredSubGames, dishonoredSubGameBox));

        dishonoredOneButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, dishonoredOneButton, dishonoredSubGames, dishonoredCategoryBox, dishonoredRestrictionsBox)
        );
        dishonoredTwoButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, dishonoredTwoButton, dishonoredSubGames, dishonoredTwoCategoryBox, dishonoredTwoRestrictionsBox)
        );
        dishonoredDotoButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, dishonoredDotoButton, dishonoredSubGames, dishonoredDotoCategoryBox, dishonoredDotoRestrictionsBox)
        );




//        zeldaRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, zeldaRadioButton, gameButtons,
//                        zeldaCategoryBox, zeldaRestrictionsBox));
//        cupheadRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, cupheadRadioButton, gameButtons,
//                        cupheadCategoryBox, cupheadRestrictionsBox));
//        hollowKnightRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, hollowKnightRadioButton, gameButtons,
//                        hollowKnightCategoryBox, hollowKnightRestrictionsBox));
//        hadesRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, hadesRadioButton, gameButtons,
//                        hadesCategoryBox, hadesRestrictionsBox));
//        celesteRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, celesteRadioButton, gameButtons,
//                        celesteCategoryBox, celesteRestrictionsBox));
//        blasphemousRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, blasphemousRadioButton, gameButtons,
//                        blasphemousCategoryBox, blasphemousRestrictionsBox));
//        multipleRadioButton.selectedProperty().addListener(
//                new GameFilter(filteredByGame, multipleRadioButton, gameButtons,
//                        multipleCategoryBox, multipleRestrictionsBox));


        //Category Filters


        ArrayList<RadioButton> demonsSoulsCategories = new ArrayList<>(List.of(demonsSoulsAny, demonsSoulsAB, demonsSoulsAA));
        for (RadioButton button : demonsSoulsCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, demonsSoulsRadioButton, button, demonsSoulsRestrictionsBox, demonsSoulsCategories));
        }

        ArrayList<RadioButton> darkSoulsCategories = new ArrayList<>(List.of(darkSoulsAny, darkSoulsAMGB, darkSoulsAB, darkSoulsAA));
        for (RadioButton button : darkSoulsCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, darkSoulsRadioButton, button, darkSoulsRestrictionsBox, darkSoulsCategories));
        }

        ArrayList<RadioButton> darkSoulsTwoCategories = new ArrayList<>(List.of(darkSoulsTwoAny, darkSoulsTwoAMGB, darkSoulsTwoAB, darkSoulsTwoAA));
        for (RadioButton button : darkSoulsTwoCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, darkSoulsTwoRadioButton, button, darkSoulsTwoRestrictionsBox, darkSoulsTwoCategories));
        }

        ArrayList<RadioButton> darkSoulsThreeCategories = new ArrayList<>(List.of(darkSoulsThreeAny, darkSoulsThreeAMGB, darkSoulsThreeAB, darkSoulsThreeAA));
        for (RadioButton button : darkSoulsThreeCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, darkSoulsThreeRadioButton, button, darkSoulsThreeRestrictionsBox, darkSoulsThreeCategories));
        }

        ArrayList<RadioButton> bloodborneCategories = new ArrayList<>(List.of(bloodborneAny, bloodborneAMGB, bloodborneAB, bloodborneABC, bloodborneAA));
        for (RadioButton button : bloodborneCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, bloodborneRadioButton, button, bloodborneRestrictionsBox, bloodborneCategories));
        }

        ArrayList<RadioButton> sekiroCategories = new ArrayList<>(List.of(sekiroShura, sekiroIS, sekiroReturn, sekiroPuri, sekiroAM, sekiroABM, sekiroABMB, sekiroMJ, sekiroAMG, sekiroAA, sekiroAllEnemy));
        for (RadioButton button : sekiroCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, sekiroRadioButton, button, sekiroRestrictionsBox, sekiroCategories));
        }
        ArrayList<RadioButton> eldenRingCategories = new ArrayList<>(List.of(eldenRingAny, eldenRingAGR, eldenRingAR, eldenRingAB, eldenRingAA));
        for (RadioButton button : eldenRingCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, eldenRingRadioButton, button, eldenRingRestrictionsBox, eldenRingCategories));
        }


        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredByText.setPredicate(run -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String[] values = newValue.toLowerCase().split(" ");
                List<String> wordList = Arrays.stream(values)
                        .map(s -> s
                                .replaceAll("[’',()]", "")
                                .replaceAll("/", " "))
                        .toList();
                String lowerCaseFilter = newValue.toLowerCase().replaceAll("’", "").replaceAll("'", "");

                if (run.getRunner().toLowerCase()
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

            });
        });


        SortedList<Run> sortedData = new SortedList<>(filteredByText);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
}
