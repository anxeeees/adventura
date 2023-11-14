package cz.vse.stae07.gui;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Inventar;
import cz.vse.stae07.logika.Predmet;
import cz.vse.stae07.observer.Observer;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.util.List;

/**
 * Třída PanelBatohu reprezentuje panel, který zobrazuje obsah inventáře hráče v rámci hry.
 * Reaguje na změny v inventáři a aktualizuje zobrazení.
 */

public class PanelBatohu implements Observer {
    private Inventar inventar;
    private HerniSvet herniSvet;


    private FlowPane flowPane = new FlowPane();

    /**
     * Konstruktor třídy PanelBatohu.
     *
     * @param herniSvet Instance herního světa, od kterého získává informace o inventáři hráče.
     */
    public PanelBatohu(HerniSvet herniSvet) {
        this.herniSvet = herniSvet; // Nastavte instanci HerniSvet
        this.inventar = herniSvet.getInventar();
        flowPane.setPrefWidth(200);
        flowPane.setPrefHeight(200);
        update();
        inventar.registerObserver(this);
    }

    /**
     * Metoda vrátí FlowPane, které reprezentuje panel inventáře hráče.
     *
     * @return FlowPane panelu inventáře.
     */
    public FlowPane getFlowPane() {
        return flowPane;
    }

    /**
     * Metoda aktualizuje obsah panelu inventáře na základě aktuálního stavu inventáře hráče.
     * Zobrazuje seznam předmětů v inventáři jako ikony obrázků.
     */

    @Override
    public void update() {
        flowPane.getChildren().clear();
        ImageView imageView2 = new ImageView(new Image(HerniPlocha.class.getClassLoader().getResourceAsStream(
                "inventar.jpg"), 100, 80, false, false));
        flowPane.getChildren().add(imageView2);
        flowPane.setPadding(new Insets(40, 40, 40, 40));

        List<Predmet> predmety = herniSvet.getInventar().getPredmety();
        for (Predmet predmet : predmety) {
            // Vytvořte název obrázku na základě názvu předmětu
            String obrazekNazev = predmet.getNazev().toLowerCase() + ".jpg";

            ImageView imageView = new ImageView(new Image(
                    HerniPlocha.class.getClassLoader().getResourceAsStream(obrazekNazev),
                    100, 80, false, false
            ));

            flowPane.getChildren().add(imageView);
        }
    }
}



