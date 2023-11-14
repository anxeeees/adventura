package cz.vse.stae07.main;

import cz.vse.stae07.UI.TextoveRozhrani;
import cz.vse.stae07.gui.HerniPlocha;
import cz.vse.stae07.gui.PanelBatohu;
import cz.vse.stae07.gui.PanelVychodu;
import cz.vse.stae07.logika.Hra;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

import java.util.Objects;


/**
 * Třída Main - slouží ke spuštění konzole.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Main extends Application {

    private final Hra hra = Hra.getSingleton();
    private final TextField uzivatelskyVstup = new TextField();

    private PanelVychodu panelVychodu;
    private Stage primaryStage;



    /**
     * Metoda pro spuštění aplikace v grafickém nebo textovém režimu na základě předaných argumentů.
     *
     * @param args Pole argumentů předaných programu při spuštění.
     */

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("gui")) {
            Application.launch();
        } else {

            Hra hra = Hra.getSingleton();
            TextoveRozhrani ui = new TextoveRozhrani(hra);
            ui.hraj();
            Platform.exit();
        }
    }

    /**
     * Vytvoří a vrátí JavaFX scénu pro grafické uživatelské rozhraní hry.
     *
     * @return Nová scéna pro hru.
     */
    private Scene createScene() {
        BorderPane borderPane = new BorderPane();
        HBox dolniPanel = new HBox();


        TextArea konzole = getConsole();
        borderPane.setCenter(konzole);

        Label popisek = new Label("Zadej příkaz:"); //popisek hboxu
        popisek.setFont(Font.font("Arial", FontWeight.NORMAL, 12));

        borderPane.setCenter(konzole); //na cele obrazovce to nastavis doprostred

        String uvod = """
                Začínáš na ulici v osmdesátkách před klubem The Saint. Jsi policista v utajení. Za poslední 3 týdny se tu událo hodně vražd a tvým úkolem je zjistit, kdo je vrah.\s

                Saháš do peněženky a kontroluješ, jestli sis nezapomněl svoji falešnou občanku. Na občance je napsáno jméno: \"""";
        konzole.setText(uvod);

        TextField jmenoHrace = new TextField();
        jmenoHrace.setPromptText("Zadej jméno");

        panelVychodu = new PanelVychodu(konzole);
        borderPane.setRight(panelVychodu.getListView());
        panelVychodu.getListView().setVisible(false);

        Button potvrditJmenoButton = new Button("Potvrdit jméno");
        potvrditJmenoButton.setOnAction(event -> {
            String jmeno = jmenoHrace.getText();
            hra.getHerniSvet().setTvojeJmeno(jmeno);
            String uvodHry = uvod + jmeno + "\"? Horší jméno mi vybrat nemohli. \"";
            konzole.setText(uvodHry);

            jmenoHrace.setVisible(false);
            potvrditJmenoButton.setVisible(false);
            TextField uzivatelskyVstup = pripravUzivatelskyVstup(borderPane, dolniPanel,konzole);
            panelVychodu.getListView().setVisible(true);

            if(uzivatelskyVstup.getText().equalsIgnoreCase("konec")) {
                panelVychodu.getListView().setVisible(false);
            }


        });


        HBox jmenoPanel = new HBox(jmenoHrace, potvrditJmenoButton);
        jmenoPanel.setAlignment(Pos.BASELINE_CENTER);



        HerniPlocha planekHry = new HerniPlocha(hra.getHerniSvet());
        AnchorPane herniPlochaAnchorPane = planekHry.getAnchorPane();
        borderPane.setTop(herniPlochaAnchorPane);



        PanelBatohu panelBatohu = new PanelBatohu(hra.getHerniSvet());
        borderPane.setLeft(panelBatohu.getFlowPane());


        HerniPlocha herniPlocha = new HerniPlocha();
        borderPane.setTop(herniPlocha.getAnchorPane());


        MenuBar menuBar = pripravMenu();


        VBox vBox = new VBox();
        Scene scene = new Scene(vBox);
        vBox.getChildren().addAll(menuBar, borderPane, jmenoPanel);

        createScene(primaryStage, scene);
        return scene;
    }

    /**
     * Metoda pro spuštění grafického rozhraní adventury.
     *
     * @param primaryStage Hlavní stage pro zobrazení grafického rozhraní.
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        Scene scene = createScene();
        createScene(primaryStage, scene);

        primaryStage.setOnCloseRequest(windowEvent -> {
            Platform.exit();
            System.exit(0);
        });
    }


    /**
     * Metoda pro vytvoření a zobrazení hlavní scény grafického rozhraní.
     *
     * @param primaryStage Hlavní stage pro zobrazení scény.
     * @param scene        Scéna obsahující grafické rozhraní hry.
     */


    private void createScene(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Polda");
        uzivatelskyVstup.requestFocus();
    }

    /**
     * Metoda pro přípravu a vrácení menu baru s různými položkami.
     *
     * @return MenuBar s různými položkami.
     */

    private MenuBar pripravMenu() {
        MenuBar menuBar = new MenuBar();
        Menu menuSoubor = new Menu("Soubor");
        Menu menuNapoveda = new Menu("Nápověda");
        menuBar.getMenus().addAll(menuSoubor, menuNapoveda);
        MenuItem itemNovaHra = new MenuItem("Nová hra");
        MenuItem itemKonec = new MenuItem("Konec");
        MenuItem itemNapoveda = new MenuItem("Nápověda");
        MenuItem itemOAplikaci = new MenuItem("O aplikaci");
        menuSoubor.getItems().addAll(itemNovaHra, itemKonec);
        menuNapoveda.getItems().addAll(itemNapoveda, itemOAplikaci);

        itemKonec.acceleratorProperty( ).set( javafx.scene.input.KeyCombination.keyCombination( "Ctrl+X" ) );



        itemKonec.setOnAction(actionEvent -> System.exit(0));


        itemNovaHra.setOnAction(actionEvent -> {
            Scene newScene = createScene();
            primaryStage.setScene(newScene);
        });

        itemNapoveda.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                WebView newWebView = new WebView();
                newWebView.getEngine().load(
                        Objects.requireNonNull(getClass().getResource("/napoveda.html")).toExternalForm()
                );
                stage.setScene(new Scene(newWebView));
                stage.show();
            }
        });

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("O aplikaci");
        alert.setHeaderText("Adventura");
        alert.setContentText("""
                Toto je adventura vytvořená v rámci semestrální práce předmětu 4IT115.
                Autor: Ester Stankovská
                Verze: 1.0.0""");

        itemOAplikaci.setOnAction(actionEvent -> alert.showAndWait());
        return menuBar;
    }

    /**
     * Metoda pro přípravu pole pro zadávání uživatelských příkazů a obsahující
     * reakce na zpracování těchto příkazů.
     *
     * @param borderPane Hlavní BorderPane obsahující herní scénu.
     * @param dolniPanel HBox obsahující pole pro zadávání příkazů.
     * @param konzole    TextArea obsahující výstupy hry.
     * @return TextField pro zadávání uživatelských příkazů.
     */

    private TextField pripravUzivatelskyVstup(BorderPane borderPane, HBox dolniPanel, TextArea konzole) {
        TextField uzivatelskyVstup = new TextField();
        borderPane.setBottom(dolniPanel);
        Label popisek = new Label("Zadej příkaz: ");
        popisek.setAlignment(Pos.CENTER);
        dolniPanel.getChildren().addAll(popisek, uzivatelskyVstup);
        dolniPanel.setAlignment(Pos.CENTER);
        Insets padding = new Insets(20, 120, 0, 0);
        dolniPanel.setPadding(padding);
        uzivatelskyVstup.setPrefHeight(30);
        uzivatelskyVstup.setPrefWidth(480);
        uzivatelskyVstup.setVisible(true);

        uzivatelskyVstup.setOnAction(actionEvent -> {
            String prikaz = uzivatelskyVstup.getText();
            String odpoved = hra.zpracujPrikaz(prikaz);
            konzole.appendText("\n" + odpoved + "\n");
            if (uzivatelskyVstup.getText().equalsIgnoreCase("konec")) {
                uzivatelskyVstup.setEditable(false);
                panelVychodu.getListView().setVisible(false);

            }
            uzivatelskyVstup.clear();

        });
        return uzivatelskyVstup;

    }

    /**
     * Metoda pro přípravu textové oblasti určené pro výstupy hry.
     *
     * @return TextArea pro zobrazování textových výstupů.
     */
    private TextArea getConsole() {
        TextArea konzole = new TextArea();
        konzole.setEditable(false);
        konzole.setWrapText(true);
        return konzole;
    }



}





