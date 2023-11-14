package cz.vse.stae07.logika;

import cz.vse.stae07.observer.Observable;
import cz.vse.stae07.observer.Observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Třída Inventar - třída představující inventář.
 * <p>
 * Obsahuje datové atributy inventáře a metody.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Inventar implements Observable {

    private final int MAXIMALNI_KAPACITA = 3;
    private int penize = 50;
    private List<Predmet> predmety = new ArrayList<>();

    private Set<Observer> observers = new HashSet<Observer>();



    /**
     * Metoda přidává předmět do inventáře.
     * Nastavuje, zda se dá sebrat.
     *
     * @param predmet, který chceme přidat
     */
    public boolean pridejPredmet(Predmet predmet) {
        if (predmety.size() == MAXIMALNI_KAPACITA) {
            return false;
        }
        predmet.setMuzeVzit(true);
        predmety.add(predmet);
        notifyObservers();
        return true;
    }

    /**
     * Metoda odebírá předmět z inventáře.
     *
     * @param predmet, který chceme odebrat
     */
    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
        notifyObservers();
    }

    /**
     * Metoda slouží k získání seznamu předmětů.
     *
     * @return předměty
     */
    public List<Predmet> getPredmety() {
        return predmety;
    }

    /**
     * Metoda slouží k získání peněz.
     *
     * @return peníze
     */
    public int getPenize() {
        return penize;
    }

    /**
     * Metoda slouží k nastavení hodnoty peněz.
     *
     * @param penize, předmět, který přijímá hodnotu
     */
    public void setPenize(int penize) {
        this.penize = penize;
    }


    /**
     * Metoda slouží k registraci změny objektu.
     *
     * @param observer, objekt, který se mění
     */

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Metoda slouží k smazání observeru.
     *
     * @param observer, objekt, který se maže
     */

    @Override
    public void removeObserver(Observer observer) {

    }

    /**
     * Metoda slouží k aktualizaci stavu objektu.
     *
     */

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
