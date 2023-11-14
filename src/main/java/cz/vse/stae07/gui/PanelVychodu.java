package cz.vse.stae07.gui;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.observer.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Třída PanelVychodu představuje panel, který zobrazuje seznam východů z aktuální lokace.
 * Uživatel může kliknutím na východ přejít do sousední lokace.
 */
public class PanelVychodu implements Observer {

    private HerniSvet herniSvet = Hra.getSingleton().getHerniSvet();
    private Hra hra = Hra.getSingleton();
    private final ListView<String> listView = new ListView<>();
    private ObservableList<String> aktualniSeznamVychodu = FXCollections.observableList(new ArrayList<>());

    /**
     * Konstruktor třídy PanelVychodu.
     *
     * @param konzole TextArea pro zobrazování textového výstupu hry.
     */
    public PanelVychodu(TextArea konzole) {
        herniSvet.registerObserver(this);
        listView.setItems(aktualniSeznamVychodu);
        update();

        listView.setOnMouseClicked(event -> {
            String nazev = listView.getSelectionModel().getSelectedItem();
            String odpoved = hra.zpracujPrikaz("jdi " + nazev);
            konzole.appendText("\n" + odpoved + "\n");

        });
    }

    /**
     * Metoda vrátí ListView, který zobrazuje seznam východů.
     *
     * @return ListView zobrazující seznam východů.
     */
    public ListView<String> getListView() {
        return listView;
    }

    /**
     * Metoda aktualizuje seznam východů v panelu na základě aktuální lokace ve hře.
     */

    @Override
    public void update() {
        aktualniSeznamVychodu.clear();

        Lokace aktualniLokace = herniSvet.getAktualniLokace();
        Collection<Lokace> vychody = aktualniLokace.getVychody();
        for (Lokace prostor : vychody) {
            aktualniSeznamVychodu.add(prostor.getNazev());
        }
    }
}

