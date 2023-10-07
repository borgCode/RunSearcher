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
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.io.*;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    private CheckBox demonsSoulsNGPlus;
    @FXML
    private CheckBox demonsSoulsNoDamage;
    @FXML
    private CheckBox demonsSoulsNoMagic;
    @FXML
    private CheckBox demonsSoulsNoRoll;
    @FXML
    private CheckBox demonsSoulsNoUpgrades;
    @FXML
    private CheckBox demonsSoulsSL1;
    @FXML
    private CheckBox demonsSoulsSorceryOnly;
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
    private CheckBox darkSoulsNGPlus;
    @FXML
    private CheckBox darkSoulsNGPlusSix;
    @FXML
    private CheckBox darkSoulsNoDamage;
    @FXML
    private CheckBox darkSoulsPyroOnly;
    @FXML
    private CheckBox darkSoulsNoRoll;
    @FXML
    private CheckBox darkSoulsMiraclesOnly;
    @FXML
    private CheckBox darkSoulsNoUpgrades;
    @FXML
    private CheckBox darkSoulsSL1;
    @FXML
    private CheckBox darkSoulsSorceryOnly;
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
    private CheckBox darkSoulsTwoNGPlus;
    @FXML
    private CheckBox darkSoulsTwoNoDamage;
    @FXML
    private CheckBox darkSoulsTwoPyroOnly;
    @FXML
    private CheckBox darkSoulsTwoNoRoll;
    @FXML
    private CheckBox darkSoulsTwoMiraclesOnly;
    @FXML
    private CheckBox darkSoulsTwoNoUpgrades;
    @FXML
    private CheckBox darkSoulsTwoSL1;
    @FXML
    private CheckBox darkSoulsTwoSorceryOnly;
    @FXML
    private CheckBox darkSoulsTwoHexOnly;
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
    private CheckBox darkSoulsThreeNGPlus;
    @FXML
    private CheckBox darkSoulsThreeNoDamage;
    @FXML
    private CheckBox darkSoulsThreePyroOnly;
    @FXML
    private CheckBox darkSoulsThreeMiraclesOnly;
    @FXML
    private CheckBox darkSoulsThreeNoUpgrades;
    @FXML
    private CheckBox darkSoulsThreeSL1;
    @FXML
    private CheckBox darkSoulsThreeSorceryOnly;
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
    private CheckBox bloodborneBL4;
    @FXML
    private CheckBox bloodborneNoDmg;
    @FXML
    private CheckBox bloodborneNoUpgrades;
    @FXML
    private CheckBox bloodborneNoBuffs;
    @FXML
    private CheckBox bloodborneNoGems;
    @FXML
    private CheckBox bloodborneNHD;
    @FXML
    private CheckBox bloodborneNG6;
    @FXML
    private CheckBox bloodborneNoRoll;
    @FXML
    private CheckBox bloodborneArcane;
    @FXML
    private HBox sekiroCategoryBox;
    @FXML
    private RadioButton sekiroShura;
    @FXML
    private RadioButton sekiroIS;
    @FXML
    private RadioButton sekiroReturn;
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
    private CheckBox sekiroAP1;
    @FXML
    private CheckBox sekiroNoDamage;
    @FXML
    private CheckBox sekiroDBNKC;
    @FXML
    private CheckBox sekiroSwordOnly;
    @FXML
    private CheckBox sekiroNoDeflect;
    @FXML
    private CheckBox sekiroSwordDmgOnly;
    @FXML
    private CheckBox sekiroNoSkills;
    @FXML
    private CheckBox sekiroNoPros;
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
    @FXML
    private CheckBox eldenRingRL1;
    @FXML
    private CheckBox eldenRingNoDamage;
    @FXML
    private CheckBox eldenRingNoUpgrades;
    @FXML
    private CheckBox eldenRingSorceryOnly;
    @FXML
    private CheckBox eldenRingNoRoll;
    @FXML
    private CheckBox eldenRingIncantOnly;
    @FXML
    private CheckBox eldenRingRegionlocked;
    @FXML
    private HBox residentEvilSubGameBox;
    @FXML
    private RadioButton residentEvil0Button;
    @FXML
    private HBox residentEvil0CategoryBox;
    @FXML
    private HBox residentEvilRestrictionsBox;
    @FXML
    private CheckBox residentEvilHandgun;
    @FXML
    private CheckBox residentEvilKnife;
    @FXML
    private CheckBox residentEvilNoCrafting;
    @FXML
    private CheckBox residentEvilKillAll;
    @FXML
    private CheckBox residentEvilNoItemBox;
    @FXML
    private CheckBox residentEvil100;
    @FXML
    private CheckBox residentEvilNGplus;
    @FXML
    private CheckBox residentEvilNoUpgrades;
    @FXML
    private RadioButton residentEvil0Any;
    @FXML
    private RadioButton residentEvil0HardAny;
    @FXML
    private RadioButton residentEvil0ExtraModes;
    @FXML
    private RadioButton residentEvil0NGPlus;
    @FXML
    private RadioButton residentEvil1Button;
    @FXML
    private RadioButton residentEvil1Normal;
    @FXML
    private RadioButton residentEvil1Hard;
    @FXML
    private RadioButton residentEvil1RealSurvivor;
    @FXML
    private RadioButton residentEvil1InvisibleEnemy;
    @FXML
    private RadioButton residentEvil1Original;
    @FXML
    private RadioButton residentEvil1Arrange;
    @FXML
    private HBox residentEvil1CategoryBox;
    @FXML
    private RadioButton residentEvil2Button;
    @FXML
    private HBox residentEvil2CategoryBox;
    @FXML
    private RadioButton residentEvil2Any;
    @FXML
    private RadioButton residentEvil2Hard;
    @FXML
    private RadioButton residentEvil2True;
    @FXML
    private RadioButton residentEvil2AllScenarios;
    @FXML
    private RadioButton residentEvil2ExtraMode;
    @FXML
    private RadioButton residentEvil2Normal;
    @FXML
    private RadioButton residentEvil3Button;
    @FXML
    private HBox residentEvil3CategoryBox;
    @FXML
    private RadioButton residentEvil3Hard;
    @FXML
    private RadioButton residentEvil3Nightmare;
    @FXML
    private RadioButton residentEvil3Inferno;
    @FXML
    private RadioButton residentEvil3Nemesis;
    @FXML
    private RadioButton residentEvil3AllBosses;
    @FXML
    private RadioButton residentEvil4Button;
    @FXML
    private HBox residentEvil4CategoryBox;
    @FXML
    private RadioButton residentEvil4Pro;
    @FXML
    private RadioButton residentEvil4Extra;
    @FXML
    private RadioButton residentEvil4NoMerchant;
    @FXML
    private RadioButton residentEvil7Button;
    @FXML
    private HBox residentEvil7CategoryBox;
    @FXML
    private RadioButton residentEvil7Normal;
    @FXML
    private RadioButton residentEvil7Madhouse;
    @FXML
    private RadioButton residentEvil7Extra;
    @FXML
    private RadioButton residentEvilVillageButton;
    @FXML
    private HBox residentEvilVillageCategoryBox;
    @FXML
    private RadioButton residentEvilVillageHard;
    @FXML
    private RadioButton residentEvilVillageVillage;
    @FXML
    private RadioButton residentEvilVillageDuke;
    @FXML
    private RadioButton residentEvilVillageExtra;
    @FXML
    private RadioButton residentEvilSurvivorButton;
    @FXML
    private HBox residentEvilSurvivorCategoryBox;
    @FXML
    private RadioButton residentEvilSurvivorAny;
    @FXML
    private RadioButton residentEvilSurvivorS;
    @FXML
    private RadioButton crash1Button;
    @FXML
    private RadioButton crashTwoButton;
    @FXML
    private RadioButton crashThreeButton;
    @FXML
    private RadioButton crashFourButton;
    @FXML
    private HBox crashSubGameBox;
    @FXML
    private HBox crashCategoryBox;
    @FXML
    private HBox crashRestrictionsBox;
    @FXML
    private CheckBox crashNoTripleMask;
    @FXML
    private RadioButton crashAny;
    @FXML
    private RadioButton crashSecretEnding;
    @FXML
    private RadioButton crashAllLevels;
    @FXML
    private RadioButton crashAllGems;
    @FXML
    private RadioButton crash105;
    @FXML
    private HBox crashTwoCategoryBox;
    @FXML
    private RadioButton crashTwoAny;
    @FXML
    private RadioButton crashTwoAllLevels;
    @FXML
    private RadioButton crashTwoAllGems;
    @FXML
    private RadioButton crashTwo102;
    @FXML
    private HBox crashThreeCategoryBox;
    @FXML
    private RadioButton crashThreeAny;
    @FXML
    private RadioButton crashThree108;
    @FXML
    private HBox crashFourCategoryBox;
    @FXML
    private RadioButton crashFourAny;
    @FXML
    private RadioButton crashFourAllTimelines;
    @FXML
    private RadioButton crashFourAllClearGems;
    @FXML
    private RadioButton crashFour106;
    @FXML
    private HBox dishonoredSubGameBox;
    @FXML
    private HBox dishonoredCategoryBox;
    @FXML
    private HBox dishonoredRestrictionsBox;
    @FXML
    private CheckBox dishonoredGhost;
    @FXML
    private CheckBox dishonoredPacifist;
    @FXML
    private CheckBox dishonoredNoUpgrades;
    @FXML
    private CheckBox dishonoredCleanHands;
    @FXML
    private CheckBox dishonoredKnifeOnly;
    @FXML
    private CheckBox dishonoredNoGear;
    @FXML
    private CheckBox dishonoredNoKnockout;
    @FXML
    private CheckBox dishonoredNGplus;
    @FXML
    private RadioButton dishonoredOneButton;
    @FXML
    private RadioButton dishonoredTwoButton;
    @FXML
    private RadioButton dishonoredDotoButton;
    @FXML
    private RadioButton dishonoredAny;
    @FXML
    private RadioButton dishonoredDLC;
    @FXML
    private RadioButton dishonoredAllMissions;
    @FXML
    private RadioButton dishonoredAllCollectibles;
    @FXML
    private HBox dishonoredTwoCategoryBox;
    @FXML
    private RadioButton dishonoredTwoAny;
    @FXML
    private RadioButton dishonoredTwoAllCollectibles;
    @FXML
    private HBox dishonoredDotoCategoryBox;
    @FXML
    private RadioButton dishonoredDotoAny;
    @FXML
    private RadioButton dishonoredDotoAllContracts;
    @FXML
    private RadioButton dishonoredDotoAllCollectibles;
    @FXML
    private RadioButton dishonoredDotoAA;
    @FXML
    private HBox zeldaSubGameBox;
    @FXML
    private RadioButton zeldaBotwButton;
    @FXML
    private RadioButton zeldaTotkButton;
    @FXML
    private HBox zeldaBotwCategoryBox;
    @FXML
    private RadioButton zeldaBotwAny;
    @FXML
    private RadioButton zeldaBotwAllSlate;
    @FXML
    private RadioButton zeldaBotwAllBeasts;
    @FXML
    private RadioButton zeldaBotwAllBeatsChampions;
    @FXML
    private RadioButton zeldaBotwABMBVanilla;
    @FXML
    private RadioButton zeldaBotwABMBDLC;
    @FXML
    private HBox zeldaBotwRestrictionsBox;
    @FXML
    private CheckBox zeldaBotwMasterMode;
    @FXML
    private CheckBox zeldaBotwBowOnly;
    @FXML
    private CheckBox zeldaBotwMasterSword;
    @FXML
    private CheckBox zeldaBotwNoBuffs;
    @FXML
    private CheckBox zeldaBotwNightOnly;
    @FXML
    private HBox zeldaTotkCategoryBox;
    @FXML
    private RadioButton zeldaTotkAny;
    @FXML
    private RadioButton zeldaTotkAllAbilities;
    @FXML
    private RadioButton zeldaTotkAllGeoglyphs;
    @FXML
    private RadioButton zeldaTotkAllDungeons;
    @FXML
    private RadioButton zeldaTotkTrueEnding;
    @FXML
    private RadioButton zeldaTotkABMB;
    @FXML
    private HBox zeldaTotkRestrictionsBox;
    @FXML
    private CheckBox zeldaTotkNoDamage;
    @FXML
    private HBox cupheadCategoryBox;
    @FXML
    private HBox cupheadRestrictionsBox;
    @FXML private CheckBox cupheadNoDash;
    @FXML private CheckBox cupheadCharmless;
    @FXML private CheckBox cupheadNoSuperArts;
    @FXML private CheckBox cupheadAllPhases;
    @FXML private CheckBox cupheadAllSecretPhases;
    @FXML private CheckBox cupheadAllKingDice;
    @FXML private CheckBox cupheadTwinHeart;
    @FXML private CheckBox cupheadAllPerfectGrades;
    @FXML
    private RadioButton cupheadAny;
    @FXML
    private RadioButton cupheadAllFlags;
    @FXML
    private RadioButton cupheadAllIsles;
    @FXML
    private RadioButton cupheadAllIslesFull;
    @FXML
    private RadioButton cupheadDLCAny;
    @FXML
    private RadioButton cupheadDLCFull;
    @FXML
    private RadioButton cupheadExpertAny;
    @FXML
    private RadioButton cupheadExpertAllFlags;
    @FXML
    private RadioButton cupheadExpertAllIsles;
    @FXML
    private RadioButton cupheadExpertAllIslesFull;
    @FXML
    private RadioButton cupheadExpertDLCAny;
    @FXML
    private RadioButton cupheadExpertDLCFull;
    @FXML
    private HBox hollowKnightCategoryBox;
    @FXML
    private HBox hollowKnightRestrictionsBox;
    @FXML
    private CheckBox hollowKnightNoDamage;
    @FXML
    private CheckBox hollowKnightNailOnly;
    @FXML
    private CheckBox hollowKnightNoUpgrades;
    @FXML
    private CheckBox hollowKnightSkipLess;
    @FXML
    private RadioButton hollowKnightAny;
    @FXML
    private RadioButton hollowKnightAllSkills;
    @FXML
    private RadioButton hollowKnightTrueEnding;
    @FXML
    private RadioButton hollowKnightAMGB;
    @FXML
    private RadioButton hollowKnightLow;
    @FXML
    private RadioButton hollowKnight112;
    @FXML
    private RadioButton hollowKnightPantheon;
    @FXML
    private HBox celesteCategoryBox;
    @FXML
    private HBox celesteRestrictionsBox;
    @FXML
    private RadioButton celesteAny;
    @FXML
    private RadioButton celesteAllRedBerries;
    @FXML
    private RadioButton celesteAllBSides;
    @FXML
    private RadioButton celesteTrueEnding;
    @FXML
    private RadioButton celesteAllChaptersAndSides;
    @FXML
    private HBox hadesCategoryBox;
    @FXML
    private HBox hadesRestrictionsBox;
    @FXML
    private CheckBox hadesNoBoons;
    @FXML
    private CheckBox hadesNoDash;
    @FXML
    private CheckBox hadesDashOnly;
    @FXML
    private CheckBox hadesNoNyx;
    @FXML
    private CheckBox hadesNoChoice;
    @FXML
    private CheckBox hadesNoCompanion;
    @FXML
    private RadioButton hadesAny;
    @FXML
    private RadioButton hadesEM4;
    @FXML
    private RadioButton hadesGodOnly;
    @FXML
    private HBox blasphemousCategoryBox;
    @FXML
    private HBox blasphemousRestrictionsBox;
    @FXML private CheckBox blasphemousNoDamage;
    @FXML private CheckBox blasphemousSkipless;
    @FXML private CheckBox blasphemousMeleeOnly;
    @FXML
    private RadioButton blasphemousAny;
    @FXML
    private RadioButton blasphemousEndingA;
    @FXML
    private RadioButton blasphemousNGPlus;
    @FXML
    private RadioButton blasphemousLastSorrow;
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
    RestrictionsMap restrictions = new RestrictionsMap();


    public void initialize() {
        runnerColumn.setCellValueFactory(new PropertyValueFactory<>("runner"));
        gameColumn.setCellValueFactory(new PropertyValueFactory<>("game"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        runColumn.setCellValueFactory(new PropertyValueFactory<>("runName"));
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("runLink"));
        linkColumn.setCellFactory(new Callback<TableColumn<Run, String>, TableCell<Run, String>>() {
            @Override
            public TableCell<Run, String> call(TableColumn<Run, String> runStringTableColumn) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            Hyperlink hyperlink = new Hyperlink(item);
                            hyperlink.setOnAction(event -> openLink(item));
                            setGraphic(hyperlink);
                        }
                    }

                    private void openLink(String item) {
                        try {
                            URI uri = new URI(item);
                            Desktop.getDesktop().browse(uri);
                        } catch (URISyntaxException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                };
            }
        });
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


        restrictions.populateHashMap();


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
                    content.putString(data.getRunLink());
                } else {
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
        FilteredList<Run> filteredByRestriction = new FilteredList<>(filteredByGame, b -> true);
        FilteredList<Run> filteredByText = new FilteredList<>(filteredByRestriction, b -> true);


        //Restriction lists

        ArrayList<CheckBox> demonsRestrictions = new ArrayList<>(List.of(
                demonsSoulsSL1, demonsSoulsNGPlus, demonsSoulsNoDamage, demonsSoulsNoMagic,
                demonsSoulsNoRoll, demonsSoulsNoUpgrades, demonsSoulsSorceryOnly
        ));

        ArrayList<CheckBox> darkSoulsRestrictions = new ArrayList<>(List.of(
                darkSoulsNGPlus, darkSoulsNGPlusSix, darkSoulsNoDamage,
                darkSoulsPyroOnly, darkSoulsNoRoll, darkSoulsMiraclesOnly,
                darkSoulsNoUpgrades, darkSoulsSL1, darkSoulsSorceryOnly
        ));

        ArrayList<CheckBox> darkSoulsTwoRestrictions = new ArrayList<>(List.of(
                darkSoulsTwoNGPlus, darkSoulsTwoNoDamage, darkSoulsTwoPyroOnly,
                darkSoulsTwoNoRoll, darkSoulsTwoMiraclesOnly, darkSoulsTwoNoUpgrades,
                darkSoulsTwoSL1, darkSoulsTwoSorceryOnly, darkSoulsTwoHexOnly
        ));

        ArrayList<CheckBox> darkSoulsThreeRestrictions = new ArrayList<>(List.of(
                darkSoulsThreeNGPlus, darkSoulsThreeNoDamage, darkSoulsThreePyroOnly,
                darkSoulsThreeMiraclesOnly, darkSoulsThreeNoUpgrades, darkSoulsThreeSL1, darkSoulsThreeSorceryOnly
        ));

        ArrayList<CheckBox> bloodborneRestrictions = new ArrayList<>(List.of(
                bloodborneBL4, bloodborneNoDmg, bloodborneNoUpgrades, bloodborneNoBuffs,
                bloodborneNoGems, bloodborneNHD, bloodborneNG6, bloodborneNoRoll, bloodborneArcane));

        ArrayList<CheckBox> sekiroRestrictions = new ArrayList<>(List.of(
                sekiroAP1, sekiroNoDamage, sekiroDBNKC, sekiroSwordOnly, sekiroNoDeflect,
                sekiroSwordDmgOnly, sekiroNoSkills, sekiroNoPros));

        ArrayList<CheckBox> eldenRingRestrictions = new ArrayList<>(List.of(
                eldenRingRL1, eldenRingNoDamage, eldenRingNoUpgrades, eldenRingSorceryOnly,
                eldenRingNoRoll, eldenRingIncantOnly, eldenRingRegionlocked));

        ArrayList<CheckBox> residentEvilRestrictions = new ArrayList<>(List.of(
                residentEvilHandgun, residentEvilKnife, residentEvilNoCrafting,
                residentEvilKillAll, residentEvilNoItemBox, residentEvil100, residentEvilNGplus, residentEvilNoUpgrades));

        ArrayList<CheckBox> crashRestrictions = new ArrayList<>(List.of(crashNoTripleMask));

        ArrayList<CheckBox> dishonoredRestrictions = new ArrayList<>(List.of(
                dishonoredGhost, dishonoredPacifist, dishonoredNoUpgrades,
                dishonoredCleanHands, dishonoredKnifeOnly, dishonoredNoGear,
                dishonoredNoKnockout, dishonoredNGplus));

        ArrayList<CheckBox> zeldaBotwRestrictions = new ArrayList<>(List.of(
                zeldaBotwMasterMode, zeldaBotwBowOnly, zeldaBotwMasterSword,
                zeldaBotwNoBuffs, zeldaBotwNightOnly));

        ArrayList<CheckBox> zeldaTotkRestrictions = new ArrayList<>(List.of(zeldaTotkNoDamage));

        ArrayList<CheckBox> cupheadRestrictions = new ArrayList<>(List.of(
                cupheadNoDash, cupheadCharmless, cupheadNoSuperArts, cupheadAllPhases,
                cupheadAllSecretPhases, cupheadAllKingDice, cupheadTwinHeart, cupheadAllPerfectGrades));

        ArrayList<CheckBox> hollowKnightRestrictions = new ArrayList<>(List.of(
                hollowKnightNoDamage, hollowKnightNailOnly, hollowKnightNoUpgrades,
                hollowKnightSkipLess));

        ArrayList<CheckBox> hadesRestrictions = new ArrayList<>(List.of(
                hadesNoChoice, hadesNoBoons, hadesDashOnly, hadesNoDash, hadesNoCompanion,
                hadesNoNyx));

        ArrayList<CheckBox> celesteRestrictions = new ArrayList<>();

        ArrayList<CheckBox> blasphemousRestrictions = new ArrayList<>(List.of(
                blasphemousNoDamage, blasphemousSkipless, blasphemousMeleeOnly
        ));

        ArrayList<ArrayList<CheckBox>> restrictionsList = new ArrayList<>(List.of(
                demonsRestrictions, darkSoulsRestrictions, darkSoulsTwoRestrictions, darkSoulsThreeRestrictions,
                bloodborneRestrictions, sekiroRestrictions, eldenRingRestrictions, crashRestrictions,
                dishonoredRestrictions, zeldaBotwRestrictions, zeldaTotkRestrictions, residentEvilRestrictions,
                cupheadRestrictions, hollowKnightRestrictions, hadesRestrictions, celesteRestrictions, blasphemousRestrictions
        ));


        //Category Filters


        ArrayList<RadioButton> demonsSoulsCategories = new ArrayList<>(
                List.of(demonsSoulsAny, demonsSoulsAB, demonsSoulsAA));
        for (
                RadioButton button : demonsSoulsCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, demonsSoulsRadioButton, button,
                    demonsSoulsRestrictionsBox, demonsSoulsCategories));
        }

        ArrayList<RadioButton> darkSoulsCategories = new ArrayList<>(
                List.of(darkSoulsAny, darkSoulsAMGB, darkSoulsAB, darkSoulsAA));
        for (
                RadioButton button : darkSoulsCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, darkSoulsRadioButton, button,
                    darkSoulsRestrictionsBox, darkSoulsCategories));
        }

        ArrayList<RadioButton> darkSoulsTwoCategories = new ArrayList<>(
                List.of(darkSoulsTwoAny, darkSoulsTwoAMGB, darkSoulsTwoAB, darkSoulsTwoAA));
        for (
                RadioButton button : darkSoulsTwoCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, darkSoulsTwoRadioButton, button,
                    darkSoulsTwoRestrictionsBox, darkSoulsTwoCategories));
        }

        ArrayList<RadioButton> darkSoulsThreeCategories = new ArrayList<>(
                List.of(darkSoulsThreeAny, darkSoulsThreeAMGB, darkSoulsThreeAB, darkSoulsThreeAA));
        for (
                RadioButton button : darkSoulsThreeCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, darkSoulsThreeRadioButton, button,
                    darkSoulsThreeRestrictionsBox, darkSoulsThreeCategories));
        }

        ArrayList<RadioButton> bloodborneCategories = new ArrayList<>(
                List.of(bloodborneAny, bloodborneAMGB, bloodborneAB, bloodborneABC, bloodborneAA));
        for (
                RadioButton button : bloodborneCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, bloodborneRadioButton, button,
                    bloodborneRestrictionsBox, bloodborneCategories));
        }

        ArrayList<RadioButton> sekiroCategories = new ArrayList<>(
                List.of(sekiroShura, sekiroIS, sekiroReturn, sekiroPuri, sekiroAM, sekiroABM, sekiroABMB, sekiroMJ, sekiroAMG, sekiroAA, sekiroAllEnemy));
        for (
                RadioButton button : sekiroCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, sekiroRadioButton, button,
                    sekiroRestrictionsBox, sekiroCategories));
        }

        ArrayList<RadioButton> eldenRingCategories = new ArrayList<>(
                List.of(eldenRingAny, eldenRingAGR, eldenRingAR, eldenRingAB, eldenRingAA));
        for (
                RadioButton button : eldenRingCategories) {
            button.selectedProperty().addListener(new CategoryFilter(filteredByGame, eldenRingRadioButton, button,
                    eldenRingRestrictionsBox, eldenRingCategories));
        }

        ArrayList<RadioButton> residentEvil0Categories = new ArrayList<>(
                List.of(residentEvil0Any, residentEvil0HardAny, residentEvil0ExtraModes, residentEvil0NGPlus));
        for (
                RadioButton button : residentEvil0Categories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvil0Button, button,
                            residentEvilRestrictionsBox, residentEvil0Categories));
        }

        ArrayList<RadioButton> residentEvil1Categories = new ArrayList<>(
                List.of(residentEvil1Normal, residentEvil1Hard, residentEvil1RealSurvivor,
                        residentEvil1InvisibleEnemy, residentEvil1Original, residentEvil1Arrange));
        for (
                RadioButton button : residentEvil1Categories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvil1Button, button,
                            residentEvilRestrictionsBox, residentEvil1Categories));
        }

        ArrayList<RadioButton> residentEvil2Categories = new ArrayList<>(
                List.of(residentEvil2Any, residentEvil2Hard, residentEvil2True,
                        residentEvil2AllScenarios, residentEvil2ExtraMode, residentEvil2Normal));
        for (
                RadioButton button : residentEvil2Categories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvil2Button, button,
                            residentEvilRestrictionsBox, residentEvil2Categories));
        }

        ArrayList<RadioButton> residentEvil3Categories = new ArrayList<>(
                List.of(residentEvil3Hard, residentEvil3Nightmare, residentEvil3Inferno,
                        residentEvil3Nemesis, residentEvil3AllBosses));
        for (
                RadioButton button : residentEvil3Categories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvil3Button, button,
                            residentEvilRestrictionsBox, residentEvil3Categories));
        }

        ArrayList<RadioButton> residentEvil4Categories = new ArrayList<>(
                List.of(residentEvil4Pro, residentEvil4Extra, residentEvil4NoMerchant));
        for (
                RadioButton button : residentEvil4Categories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvil4Button, button,
                            residentEvilRestrictionsBox, residentEvil4Categories));
        }

        ArrayList<RadioButton> residentEvil7Categories = new ArrayList<>(
                List.of(residentEvil7Normal, residentEvil7Madhouse, residentEvil7Extra));
        for (
                RadioButton button : residentEvil7Categories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvil7Button, button,
                            residentEvilRestrictionsBox, residentEvil7Categories));
        }

        ArrayList<RadioButton> residentEvilVillageCategories = new ArrayList<>(
                List.of(residentEvilVillageHard, residentEvilVillageVillage,
                        residentEvilVillageDuke, residentEvilVillageExtra));
        for (
                RadioButton button : residentEvilVillageCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvilVillageButton, button,
                            residentEvilRestrictionsBox, residentEvilVillageCategories));
        }

        ArrayList<RadioButton> residentEvilSurvivorCategories = new ArrayList<>(
                List.of(residentEvilSurvivorAny, residentEvilSurvivorS));
        for (
                RadioButton button : residentEvilSurvivorCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, residentEvilSurvivorButton, button,
                            residentEvilRestrictionsBox, residentEvilSurvivorCategories));
        }

        ArrayList<RadioButton> crashOneCategories = new ArrayList<>(
                List.of(crashAny, crashSecretEnding, crashAllLevels,
                        crashAllGems, crash105));
        for (
                RadioButton button : crashOneCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, crash1Button, button,
                            crashRestrictionsBox, crashOneCategories));
        }

        ArrayList<RadioButton> crashTwoCategories = new ArrayList<>(
                List.of(crashTwoAny, crashTwoAllLevels, crashTwoAllGems, crashTwo102));
        for (
                RadioButton button : crashTwoCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, crashTwoButton, button,
                            crashRestrictionsBox, crashTwoCategories));
        }

        ArrayList<RadioButton> crashThreeCategories = new ArrayList<>(
                List.of(crashThreeAny, crashThree108));
        for (
                RadioButton button : crashThreeCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, crashThreeButton, button,
                            crashRestrictionsBox, crashThreeCategories));
        }

        ArrayList<RadioButton> crashFourCategories = new ArrayList<>(
                List.of(crashFourAny, crashFourAllTimelines, crashFourAllClearGems, crashFour106));
        for (
                RadioButton button : crashFourCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, crashFourButton, button,
                            crashRestrictionsBox, crashFourCategories));
        }

        ArrayList<RadioButton> dishonoredCategories = new ArrayList<>(
                List.of(dishonoredAny, dishonoredDLC, dishonoredAllMissions, dishonoredAllCollectibles));
        for (
                RadioButton button : dishonoredCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, dishonoredOneButton, button,
                            dishonoredRestrictionsBox, dishonoredCategories));
        }

        ArrayList<RadioButton> dishonoredTwoCategories = new ArrayList<>(
                List.of(dishonoredTwoAny, dishonoredTwoAllCollectibles));
        for (
                RadioButton button : dishonoredTwoCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, dishonoredTwoButton, button,
                            dishonoredRestrictionsBox, dishonoredTwoCategories));
        }

        ArrayList<RadioButton> dishonoredDotoCategories = new ArrayList<>(
                List.of(dishonoredDotoAny, dishonoredDotoAllContracts,
                        dishonoredDotoAllCollectibles, dishonoredDotoAA));
        for (
                RadioButton button : dishonoredDotoCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, dishonoredDotoButton, button,
                            dishonoredRestrictionsBox, dishonoredDotoCategories));
        }

        ArrayList<RadioButton> zeldaBotwCategories = new ArrayList<>(
                List.of(zeldaBotwAny, zeldaBotwAllSlate, zeldaBotwAllBeasts,
                        zeldaBotwAllBeatsChampions, zeldaBotwABMBVanilla, zeldaBotwABMBDLC));
        for (
                RadioButton button : zeldaBotwCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, zeldaBotwButton, button,
                            zeldaBotwRestrictionsBox, zeldaBotwCategories));
        }

        ArrayList<RadioButton> zeldaTotkCategories = new ArrayList<>(
                List.of(zeldaTotkAny, zeldaTotkAllAbilities, zeldaTotkAllGeoglyphs,
                        zeldaTotkAllDungeons, zeldaTotkTrueEnding, zeldaTotkABMB));
        for (
                RadioButton button : zeldaTotkCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, zeldaTotkButton, button,
                            zeldaTotkRestrictionsBox, zeldaTotkCategories));
        }

        ArrayList<RadioButton> cupheadCategories = new ArrayList<>(
                List.of(cupheadAny, cupheadAllFlags, cupheadAllIsles,
                        cupheadAllIslesFull, cupheadDLCAny, cupheadDLCFull,
                        cupheadExpertAny, cupheadExpertAllFlags, cupheadExpertAllIsles,
                        cupheadExpertAllIslesFull, cupheadExpertDLCAny, cupheadExpertDLCFull));
        for (
                RadioButton button : cupheadCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, cupheadRadioButton, button,
                            cupheadRestrictionsBox, cupheadCategories));
        }

        ArrayList<RadioButton> hollowKnightCategories = new ArrayList<>(
                List.of(hollowKnightAny, hollowKnightAllSkills, hollowKnightTrueEnding,
                        hollowKnightAMGB, hollowKnightLow, hollowKnight112, hollowKnightPantheon));
        for (
                RadioButton button : hollowKnightCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, hollowKnightRadioButton, button,
                            hollowKnightRestrictionsBox, hollowKnightCategories));
        }

        ArrayList<RadioButton> celesteCategories = new ArrayList<>(
                List.of(celesteAny, celesteAllRedBerries, celesteAllBSides,
                        celesteTrueEnding, celesteAllChaptersAndSides));
        for (
                RadioButton button : celesteCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, celesteRadioButton, button,
                            celesteRestrictionsBox, celesteCategories));
        }

        ArrayList<RadioButton> hadesCategories = new ArrayList<>(
                List.of(hadesAny, hadesEM4, hadesGodOnly));
        for (
                RadioButton button : hadesCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, hadesRadioButton, button,
                            hadesRestrictionsBox, hadesCategories));
        }

        ArrayList<RadioButton> blasphemousCategories = new ArrayList<>(
                List.of(blasphemousAny, blasphemousEndingA, blasphemousNGPlus,
                        blasphemousLastSorrow));
        for (
                RadioButton button : blasphemousCategories) {
            button.selectedProperty().addListener(
                    new CategoryFilter(filteredByGame, blasphemousRadioButton, button,
                            blasphemousRestrictionsBox, blasphemousCategories));
        }


        //Game filters

        demonsSoulsRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, demonsSoulsRadioButton, gameButtons,
                        demonsSoulsCategoryBox, demonsSoulsRestrictionsBox, demonsSoulsCategories,
                        filteredByRestriction, demonsRestrictions));

        darkSoulsRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, darkSoulsRadioButton, gameButtons,
                        darkSoulsCategoryBox, darkSoulsRestrictionsBox, darkSoulsCategories,
                        filteredByRestriction, darkSoulsRestrictions));

        darkSoulsTwoRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, darkSoulsTwoRadioButton, gameButtons,
                        darkSoulsTwoCategoryBox, darkSoulsTwoRestrictionsBox, darkSoulsTwoCategories,
                        filteredByRestriction, darkSoulsTwoRestrictions));

        darkSoulsThreeRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, darkSoulsThreeRadioButton, gameButtons,
                        darkSoulsThreeCategoryBox, darkSoulsThreeRestrictionsBox, darkSoulsThreeCategories,
                        filteredByRestriction, darkSoulsThreeRestrictions));

        bloodborneRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, bloodborneRadioButton, gameButtons,
                        bloodborneCategoryBox, bloodborneRestrictionsBox, bloodborneCategories,
                        filteredByRestriction, bloodborneRestrictions));

        sekiroRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, sekiroRadioButton, gameButtons,
                        sekiroCategoryBox, sekiroRestrictionsBox, sekiroCategories, filteredByRestriction,
                        sekiroRestrictions));

        eldenRingRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, eldenRingRadioButton, gameButtons,
                        eldenRingCategoryBox, eldenRingRestrictionsBox, eldenRingCategories,
                        filteredByRestriction, eldenRingRestrictions));

        ArrayList<RadioButton> residentEvilSubGames = new ArrayList<>(
                List.of(residentEvil0Button, residentEvil1Button, residentEvil2Button,
                        residentEvil3Button, residentEvil4Button, residentEvil7Button,
                        residentEvilVillageButton, residentEvilSurvivorButton));
        residentEvilRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, residentEvilRadioButton,
                        residentEvilSubGames, residentEvilSubGameBox));

        residentEvil0Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil0Button,
                        residentEvilSubGames, residentEvil0CategoryBox,
                        residentEvilRestrictionsBox, residentEvil0Categories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvil1Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil1Button,
                        residentEvilSubGames, residentEvil1CategoryBox,
                        residentEvilRestrictionsBox, residentEvil1Categories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvil2Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil2Button,
                        residentEvilSubGames, residentEvil2CategoryBox,
                        residentEvilRestrictionsBox, residentEvil2Categories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvil3Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil3Button,
                        residentEvilSubGames, residentEvil3CategoryBox,
                        residentEvilRestrictionsBox, residentEvil3Categories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvil4Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil4Button,
                        residentEvilSubGames, residentEvil4CategoryBox,
                        residentEvilRestrictionsBox, residentEvil4Categories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvil7Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvil7Button,
                        residentEvilSubGames, residentEvil7CategoryBox,
                        residentEvilRestrictionsBox, residentEvil7Categories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvilVillageButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvilVillageButton,
                        residentEvilSubGames, residentEvilVillageCategoryBox,
                        residentEvilRestrictionsBox, residentEvilVillageCategories,
                        filteredByRestriction, residentEvilRestrictions));

        residentEvilSurvivorButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, residentEvilSurvivorButton,
                        residentEvilSubGames, residentEvilSurvivorCategoryBox,
                        residentEvilRestrictionsBox, residentEvilSurvivorCategories,
                        filteredByRestriction, residentEvilRestrictions));

        ArrayList<RadioButton> crashSubGames = new ArrayList<>(
                List.of(crash1Button, crashTwoButton, crashThreeButton, crashFourButton));

        crashRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, crashRadioButton, crashSubGames, crashSubGameBox));

        crash1Button.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crash1Button, crashSubGames,
                        crashCategoryBox, crashRestrictionsBox, crashOneCategories,
                        filteredByRestriction, crashRestrictions)
        );

        crashTwoButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crashTwoButton, crashSubGames,
                        crashTwoCategoryBox, crashRestrictionsBox, crashTwoCategories,
                        filteredByRestriction, crashRestrictions)
        );

        crashThreeButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crashThreeButton, crashSubGames,
                        crashThreeCategoryBox, crashRestrictionsBox, crashThreeCategories,
                        filteredByRestriction, crashRestrictions)
        );

        crashFourButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, crashFourButton, crashSubGames,
                        crashFourCategoryBox, crashRestrictionsBox, crashFourCategories,
                        filteredByRestriction, crashRestrictions)
        );

        ArrayList<RadioButton> dishonoredSubGames = new ArrayList<>(
                List.of(dishonoredOneButton, dishonoredTwoButton, dishonoredDotoButton));

        dishonoredRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, dishonoredRadioButton, dishonoredSubGames, dishonoredSubGameBox));

        dishonoredOneButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, dishonoredOneButton, dishonoredSubGames,
                        dishonoredCategoryBox, dishonoredRestrictionsBox, dishonoredCategories,
                        filteredByRestriction, dishonoredRestrictions)
        );
        dishonoredTwoButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, dishonoredTwoButton, dishonoredSubGames,
                        dishonoredTwoCategoryBox, dishonoredRestrictionsBox, dishonoredTwoCategories,
                        filteredByRestriction, dishonoredRestrictions)
        );
        dishonoredDotoButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, dishonoredDotoButton, dishonoredSubGames,
                        dishonoredDotoCategoryBox, dishonoredRestrictionsBox, dishonoredDotoCategories,
                        filteredByRestriction, dishonoredRestrictions)
        );

        ArrayList<RadioButton> zeldaSubGames = new ArrayList<>(
                List.of(zeldaBotwButton, zeldaTotkButton));

        zeldaRadioButton.selectedProperty().addListener(
                new SubGameBox(filteredByGame, gameButtons, zeldaRadioButton, zeldaSubGames, zeldaSubGameBox));

        zeldaBotwButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, zeldaBotwButton, zeldaSubGames,
                        zeldaBotwCategoryBox, zeldaBotwRestrictionsBox, zeldaBotwCategories,
                        filteredByRestriction, zeldaBotwRestrictions)
        );
        zeldaTotkButton.selectedProperty().addListener(
                new SubGameFilter(filteredByGame, zeldaTotkButton, zeldaSubGames,
                        zeldaTotkCategoryBox, zeldaTotkRestrictionsBox, zeldaTotkCategories,
                        filteredByRestriction, zeldaTotkRestrictions)
        );

        cupheadRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, cupheadRadioButton, gameButtons,
                        cupheadCategoryBox, cupheadRestrictionsBox, cupheadCategories,
                        filteredByRestriction, cupheadRestrictions));
        hollowKnightRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, hollowKnightRadioButton, gameButtons,
                        hollowKnightCategoryBox, hollowKnightRestrictionsBox, hollowKnightCategories,
                        filteredByRestriction, hollowKnightRestrictions));
        hadesRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, hadesRadioButton, gameButtons,
                        hadesCategoryBox, hadesRestrictionsBox, hadesCategories,
                        filteredByRestriction, hadesRestrictions));
        celesteRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, celesteRadioButton, gameButtons,
                        celesteCategoryBox, celesteRestrictionsBox, celesteCategories,
                        filteredByRestriction, celesteRestrictions));
        blasphemousRadioButton.selectedProperty().addListener(
                new GameFilter(filteredByGame, blasphemousRadioButton, gameButtons,
                        blasphemousCategoryBox, blasphemousRestrictionsBox, blasphemousCategories,
                        filteredByRestriction, blasphemousRestrictions));

        multipleRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    for (RadioButton button : gameButtons) {
                        if (button != multipleRadioButton) {
                            button.setSelected(false);
                        }
                    }
                }

                filteredByGame.setPredicate(run -> {
                    if (!multipleRadioButton.isSelected()) {
                        return true;
                    }
                    if (run.getGame().toLowerCase()
                            .replaceAll("[’',()]", "").
                            replaceAll("/", "").matches("multiple")) {
                        return true;
                    } else {
                        return false;
                    }
                });
            }

        });

        for(CheckBox box : demonsRestrictions) {
            box.selectedProperty().addListener(new RestrictionFilter(filteredByRestriction, demonsRestrictions, restrictions));

        }

        for (CheckBox box : darkSoulsRestrictions) {
            box.selectedProperty().addListener(new RestrictionFilter(filteredByRestriction, darkSoulsRestrictions, restrictions));
        }

        for (ArrayList<CheckBox> boxes : restrictionsList) {
            addRestrictionListeners(filteredByRestriction, boxes, restrictions);
        }


        searchBox.textProperty().

                addListener((observable, oldValue, newValue) ->

                {
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

                    });
                });


        SortedList<Run> sortedData = new SortedList<>(filteredByText);
        sortedData.comparatorProperty().

                bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }

    private void addRestrictionListeners(FilteredList<Run> filteredList, ArrayList<CheckBox> restrictions, RestrictionsMap map) {
        for(CheckBox box : restrictions) {
            box.selectedProperty().addListener(new RestrictionFilter(filteredList, restrictions, map));

        }
    }
}
