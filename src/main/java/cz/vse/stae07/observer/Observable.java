package cz.vse.stae07.observer;

public interface Observable {

    /**
     * Metoda slouží k registraci změny objektu.
     *
     * @param observer, objekt, který se mění
     */
    void registerObserver(Observer observer);

    /**
     * Metoda slouží k smazání observeru.
     *
     * @param observer, objekt, který se maže
     */
    void removeObserver(Observer observer);

    /**
     * Metoda slouží k aktualizaci stavu objektu.
     *
     */
    void notifyObservers();

}
