package cz.vse.stae07.logika;

/**
 * Třída Predmet - představuje předměty a jejich datové atributy a metody.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Predmet {
    private String popis;
    private String nazev;
    private Boolean muzeVzit;
    private int cena = 0;


    /**
     * Konstruktor Predmet nastavuje název a popis předmětu a zda se dá vzít.
     *
     * @param nazev,    slouží k deklaraci názvu předmětu
     * @param muzeVzit, slouží k určení, zda je předmět sebratelný nebo ne
     * @param popis,    slouží k nastavení popisu předmětu
     */
    public Predmet(String nazev, Boolean muzeVzit, String popis) {
        this.nazev = nazev;
        this.muzeVzit = muzeVzit;
        this.popis = popis;

    }

    /**
     * Vrátí název věci.
     *
     * @return název věci
     */
    public String getNazev() {
        return this.nazev;
    }

    /**
     * Vrátí, zda lze předmět vzít.
     *
     * @return true pokud jde vzít, false pokud nelze
     */
    public Boolean getMuzeVzit() {
        return this.muzeVzit;
    }

    /**
     * Nastaví cenu věci.
     *
     * @param cena, kterou věc bude mít
     */
    public void setCena(int cena) {
        this.cena = cena;
    }

    /**
     * Vrátí cenu věci.
     *
     * @return cena věci
     */
    public int getCena() {
        return this.cena;
    }

    /**
     * Nastaví, zda je věc sebratelná.
     *
     * @param muzeVzit, přiřazuje hodnotu true (může vzít) nebo false (nemůže)
     */
    public void setMuzeVzit(Boolean muzeVzit) {
        this.muzeVzit = muzeVzit;
    }


    /**
     * Vrátí popis věci.
     *
     * @return popis věci
     */
    public String getPopis() {
        return popis;
    }
}
