package cz.vse.stae07.logika;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import cz.vse.stae07.logika.prikazy.*;


/**
 * Třída Hra - třída představující logiku adventury.
 * <p>
 * Toto je hlavní třída  logiky aplikace.
 * Tato třída vytváří instanci třídy HerniSvet
 * a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 * Vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class Hra {


    private HerniSvet herniSvet;
    private boolean hraSkoncila;

    private Set<IPrikaz> prikazy;

    public Hra hra;

    /**
     * Konstuktor TextoveRozhrani - slouží k vytvoření hry.
     *
     * @param hra, propojuje instanci třídy TextoveRozhrani se zadanou herní instancí
     */


    /**
     * Tento konstruktor vytváří nový herní svět.
     * Nastavuje, že hra neskončila.
     * Přidává do hry seznam příkazů.
     */
    private Hra() {
        herniSvet = new HerniSvet();
        hraSkoncila = false;

        prikazy = new HashSet<IPrikaz>();

        PrikazKonec pk = new PrikazKonec(this);
        prikazy.add(pk);

        PrikazNapoveda pn = new PrikazNapoveda();
        prikazy.add(pn);

        PrikazJdi pj = new PrikazJdi(this);
        prikazy.add(pj);

        PrikazMluvit pmluvit = new PrikazMluvit(this);
        prikazy.add(pmluvit);

        PrikazRozhled prozhled = new PrikazRozhled(this);
        prikazy.add(prozhled);

        PrikazZobrazitInventar pinventar = new PrikazZobrazitInventar(this);
        prikazy.add(pinventar);

        PrikazPrecti precti = new PrikazPrecti(this);
        prikazy.add(precti);

        PrikazKoupit kup = new PrikazKoupit(this);
        prikazy.add(kup);

        PrikazDej dej = new PrikazDej(this);
        prikazy.add(dej);

        PrikazSeber seber = new PrikazSeber(this);
        prikazy.add(seber);

        PrikazPoloz poloz = new PrikazPoloz(this);
        prikazy.add(poloz);

        PrikazKopni kopni = new PrikazKopni(this);
        prikazy.add(kopni);

        PrikazPodplat podplat = new PrikazPodplat(this);
        prikazy.add(podplat);

        PrikazZavolat prikazZavolat = new PrikazZavolat(this);
        prikazy.add(prikazZavolat);

        PrikazOdemknout prikazOdemknout = new PrikazOdemknout(this);
        prikazy.add(prikazOdemknout);

        PrikazZapni prikazZapni = new PrikazZapni(this);
        prikazy.add(prikazZapni);

        PrikazOznac prikazOznac = new PrikazOznac(this);
        prikazy.add(prikazOznac);
    }



    public static final Hra SINGLETON = new Hra();

    /**
     * Tato metoda slouží k získání přístupu do herního světa v rámci jedné instance,
     * která je sdílena všemi částmi aplikace.
     *
     * @return SINGLETON
     */

    public static Hra getSingleton() {
        return SINGLETON;

    }

    /**
     * Tato metoda slouží k získání přístupu do herního světa.
     *
     * @return objekt typu HerniSvet
     */
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }


    /**
     * Tato metoda slouží k získání informace, zda hra skončila nebo ne.
     *
     * @return stav hry
     */
    public boolean isHraSkoncila() {

        return hraSkoncila;
    }

    /**
     * Metoda nastaví stav hry.
     *
     * @param hraSkoncila určuje nový stav hry
     */
    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }

    /**
     * Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     * Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     * Pokud ano spustí samotné provádění příkazu.
     *
     * @param vstupUzivatele text, který zadal uživatel jako příkaz do hry.
     * @return vrací se řetězec, který se má vypsat na obrazovku
     */
    public String zpracujPrikaz(String vstupUzivatele) {
        String[] slova = vstupUzivatele.split(" ");
        String nazevPrikazu = slova[0];

        String[] parametryPrikazu = new String[slova.length - 1]; //zjistuju delku pole slova a odecitam 1

        for (int i = 1; i < slova.length; i++) {
            parametryPrikazu[i - 1] = slova[i];
        }

        for (IPrikaz p : prikazy) {
            if (p.getNazev().equals(nazevPrikazu)) {
                return p.proved(parametryPrikazu);
            }
        }

        return "Tomu nerozumím, příkaz '" + nazevPrikazu + "' neznam";
    }

}

