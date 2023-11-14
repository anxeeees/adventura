package cz.vse.stae07.logika;

import java.util.HashSet;
import java.util.Set;

/**
 * Třída Lokace - nastavuje datové atributy lokaci.
 * <p>
 * Východy,název, popis, zda je průchozí.
 * Jaké předměty a postavy se v lokaci nacházejí.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Lokace {
    private String nazev; // jak se ta lokace jmenuje
    private String popis; // info o lokaci, jak to vypadá

    private boolean jePruchozi;

    private Set<Lokace> vychody;
    private Set<Postava> postavy;
    private Set<Predmet> predmety;
    private Double posTop;
    private Double posLeft;


    /**
     * Konstruktor Lokace slouží k inicializaci všech atributů lokace na základě zadaných hodnot.
     * Připravuje kolekce pro ukládání východů, postav a předmětů.
     *
     * @param nazev slouží k nastavení nového názvu lokace
     * @param popis slouží k nastavení nového popisu lokace
     */
    public Lokace(String nazev, String popis, double posTop, double posLeft) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashSet<>(); // mnozina, do ktere se pridavaji vychody
        this.postavy = new HashSet<>();
        this.predmety = new HashSet<>();
        this.jePruchozi = true;
        this.posTop = posTop;
        this.posLeft = posLeft;
    }

    /**
     * Tato metoda odstraňuje postavu z lokace.
     *
     * @param postava, je ze třídy Postava a vymaže se z kolekce
     */
    public void odstranPostavu(Postava postava) {
        postavy.remove(postava);
    }

    /**
     * Tato metoda odstraňuje předmět z lokace.
     *
     * @param predmet, je ze třídy Predmet a vymaže se z kolekce
     */
    public void odstranPredmet(Predmet predmet) {
        predmety.remove(predmet);
    }

    /**
     * Tato metoda porovnává název předmětu s předmětem v lokaci a určuje,
     * zda se v lokaci nachází.
     *
     * @param nazev, porovnává název předmětů
     */
    public boolean najdiPredmet(String nazev) {
        for (Predmet predmet : predmety) {
            if (predmet.getNazev().equals(nazev)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tato metoda přidává východy k lokacím.
     *
     * @param vychod, porovnává název východu a poté ho přidá do kolekce východů
     */
    public void pridejVychod(Lokace vychod) {
        vychody.add(vychod);
    }

    /**
     * Tato metoda slouží k získání kolekce východů dané lokace.
     *
     * @return kolekci východů
     */
    public Set<Lokace> getVychody() {
        return vychody;
    }

    /**
     * Tato metoda slouží k ověření, zda z aktuální lokace existuje východ do jiné lokace s daným názvem.
     *
     * @param nazevLokace, porovnání lokace s názvem lokace v parametru
     */
    public boolean maVychod(String nazevLokace) {
        for (Lokace l : vychody) {
            if (l.getNazev().equals(nazevLokace)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tato metoda postupně prochází všechny východy.
     * Pro každý východ porovnává název lokace pomocí metody.
     *
     * @param nazevLokace, porovnání lokace s názvem lokace v parametru
     */
    public Lokace getVychod(String nazevLokace) {
        for (Lokace l : vychody) {
            if (l.getNazev().equals(nazevLokace)) {
                return l;
            }
        }
        return null;
    }


    /**
     * Tato metoda slouží k získání názvu lokace.
     *
     * @return název lokace
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Tato metoda slouží k získání popisu lokace.
     *
     * @return popis lokace
     */
    public String getPopis() {
        return popis;
    }

    /**
     * Tato metoda slouží k nastavení popisu lokace.
     *
     * @param popis, který se nastaví pro dané lokace
     */
    public void setPopis(String popis) {
        this.popis = popis;
    }

    /**
     * Tato metoda slouží k přidání postav do lokace.
     *
     * @param p, postava přidána do seznamu postav v lokaci
     */
    public void addPostava(Postava p) {
        this.postavy.add(p);
    }

    /**
     * Tato metoda slouží k získání seznamu postav, které se v lokaci nacházejí.
     *
     * @return postavy v lokaci
     */
    public Set<Postava> getPostavy() {
        return this.postavy;
    }

    /**
     * Tato metoda slouží k přidání do kolekce předmětů v lokaci.
     *
     * @param predmet v lokaci
     */
    public void addPredmet(Predmet predmet) {
        this.predmety.add(predmet);
    }

    /**
     * Tato metoda slouží k získání seznamu předmětů, které se v lokaci nacházejí.
     *
     * @return předměty v lokaci
     */
    public Set<Predmet> getPredmety() {
        return predmety;
    }

    /**
     * Tato metoda slouží k získání informací, zda je lokace průchozí nebo ne.
     *
     * @return že je průchozí
     */
    public boolean isJePruchozi() {
        return jePruchozi;
    }

    /**
     * Tato metoda nastavuje, zda je lokace průchozí nebo ne.
     *
     * @param jePruchozi, porovnává se s lokacemi, které jsou průchozí
     */
    public void setJePruchozi(boolean jePruchozi) {
        this.jePruchozi = jePruchozi;
    }


    /**
     * Tato metoda vrací pozici na mapě ve směru nahoru.
     *
     * @return Pozice na mapě ve směru nahoru.
     */

    public Double getPosTop() {
        return posTop;
    }

    /**
     * Tato metoda vrací pozici na mapě ve směru doleva.
     *
     * @return Pozice na mapě ve směru doleva.
     */

    public Double getPosLeft() {
        return posLeft;
    }
}
