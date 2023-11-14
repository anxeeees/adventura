package cz.vse.stae07.logika;

import cz.vse.stae07.logika.postavy.*;
import cz.vse.stae07.observer.Observable;
import cz.vse.stae07.observer.Observer;

import java.util.Map;
import java.util.WeakHashMap;


/**
 * Třída HerniSvet - představuje mapu a stav adventury.
 * <p>
 * Tato třída obsahuje prvky, ze kterých se hra skládá:
 * vytváří nový inventář, lokace, předměty a postavy
 * propojuje prostory pomocí východů
 * pamatuje si aktuální prostor, ve kterém se háč nachází
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class HerniSvet implements Observable {
    private Lokace aktualniLokace;
    private Inventar inventar;
    private TajemnyMuz tajemnyMuz;
    private String tvojeJmeno;

    private int pocetKopnutiDoAutomatu = 0;
    private final int MAXIMALNI_POCET_KOPNUTI_DO_AUTOMATU = 2;

    private Map<Observer, Object> observers = new WeakHashMap<>();




    /**
     * Tento konstruktor vytváří lokace, předměty, postavy
     * a jejich popisy.
     * Inventář, východy a zda je lokace průchozí.
     */
    public HerniSvet() {
        inventar = new Inventar();

        Lokace ulice = new Lokace("ulice", "Docela nebezpečná ulice u jednoho z nejznámějších klubů v New York City.",135,420);
        Lokace klub = new Lokace("klub", "Fuj tady to smrdí.",135,270);
        Lokace bar = new Lokace("bar", "Dva potetovaný týpci a dvojčata. Možná něco budou vědět.",30,270);
        Lokace atelier = new Lokace("atelier", "Takže tady bydlí ten podivín.",135,580);
        Lokace podzemi = new Lokace("podzemi", "Asi už jsem viděl všechno.",250,270);
        Lokace budka = new Lokace("budka", "Budka s telefonem.",30,425);
        Lokace knihovna = new Lokace("knihovna", "Najdou se tu starý zprávy.",250,440);

        ulice.pridejVychod(atelier);
        atelier.pridejVychod(ulice);

        ulice.pridejVychod(klub);
        klub.pridejVychod(ulice);

        klub.pridejVychod(bar);
        bar.pridejVychod(klub);

        klub.pridejVychod(podzemi);
        podzemi.pridejVychod(klub);

        ulice.pridejVychod(budka);
        budka.pridejVychod(ulice);

        ulice.pridejVychod(knihovna);
        knihovna.pridejVychod(ulice);


        atelier.addPostava(new ZvracenyFotograf());
        this.tajemnyMuz = new TajemnyMuz(klub, podzemi);
        klub.addPostava(tajemnyMuz);
        bar.addPostava(new Lupin());
        bar.addPostava(new Snupin());
        ulice.addPostava(new Fetak());
        podzemi.addPostava(new Prostitutka(this));


        Predmet papir = new Predmet("papir", false, "Něco se tu válí. Toho jsem si nevšim.");
        podzemi.addPredmet(papir);


        Predmet cigareta = new Predmet("cigareta", false, "Cíga za 150? Ještě, že už nekouřim.");
        cigareta.setCena(150);
        bar.addPredmet(cigareta);

        Predmet automat = new Predmet("automat", false, "Gambler ze mě nebude, ale třeba z toho" +
                " vypadnou nějaký prachy.");
        klub.addPredmet(automat);

        Predmet telefon = new Predmet("telefon", false, "Hmmm. Stará vykopávka.");
        budka.addPredmet(telefon);

        Predmet radio = new Predmet("radio", false, "Tak copak tam máme?");
        atelier.addPredmet(radio);
        atelier.setJePruchozi(false);

        Predmet plakat = new Predmet("plakat", true, "Toho už jsem někde viděl.");
        klub.addPredmet(plakat);

        Predmet walkman = new Predmet("walkman", true, "Bude se někdo zlobit, když si ho nenápadně ukradnu?");
        klub.addPredmet(walkman);

        Predmet zvykacky = new Predmet("zvykacky", true, "Hm. U toho chlápka se válí moje oblíbený žvýkačky.");
        podzemi.addPredmet(zvykacky);

        Predmet fotografieJedna = new Predmet("fotografie1", false, "Týpek z klubu.");
        atelier.addPredmet(fotografieJedna);

        Predmet fotografieDva = new Predmet("fotografie2", false, "Fred.");
        atelier.addPredmet(fotografieDva);

        Predmet novinyB = new Predmet("noviny2", false, "Tak tady už tak hezký obrázky nejsou.");
        knihovna.addPredmet(novinyB);

        Predmet novinyA = new Predmet("noviny1", false, "Hezké obrázky.");
        knihovna.addPredmet(novinyA);

        aktualniLokace = ulice;
    }


    /**
     * Tato metoda slouží k získání aktuální lokace.
     *
     * @return lokaci, ve které se nacházím
     */
    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    /**
     * Tato metoda slouží k nastavení aktuální lokace.
     *
     * @param aktualniLokace, představuje novou lokaci, do které se hráč přesouvá
     */
    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
        notifyObservers();
    }

    /**
     * Tato metoda slouží k získání aktuální inventáře.
     *
     * @return inventář
     */
    public Inventar getInventar() {
        return inventar;
    }

    /**
     * Tato metoda slouží k nastavení inventáře.
     *
     * @param inventar, nový inventář v herním světě
     */
    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    /**
     * Tato metoda slouží k získání jména hráče.
     *
     * @return jméno hráče, které si vybral
     */
    public String getTvojeJmeno() {
        return tvojeJmeno;
    }

    /**
     * Tato metoda slouží k nastavení jména hráče.
     *
     * @param tvojeJmeno, jméno, které si hráč v herním světě zvolí
     */
    public void setTvojeJmeno(String tvojeJmeno) {
        this.tvojeJmeno = tvojeJmeno;
    }

    /**
     * Tato metoda slouží k získání počtu kopnutí do automatu.
     *
     * @return hodnotu počtu kopnutí, která je uložena v proměnné pocetKopnutiDoAutomatu
     */
    public int getPocetKopnutiDoAutomatu() {
        return pocetKopnutiDoAutomatu;
    }

    /**
     * Tato metoda slouží k nastavení počtu kopnutí do automatu.
     *
     * @param pocetKopnutiDoAutomatu, předá novou hodnotu počtu hodnutí do automatu
     */
    public void setPocetKopnutiDoAutomatu(int pocetKopnutiDoAutomatu) {
        this.pocetKopnutiDoAutomatu = pocetKopnutiDoAutomatu;
    }

    /**
     * Tato metoda slouží k nastavení maximálního počtu kopnutí do automatu.
     *
     * @return stejnou hodnotu, která je předem určena a nemění se během běhu programu
     */
    public int getMAXIMALNI_POCET_KOPNUTI_DO_AUTOMATU() {
        return MAXIMALNI_POCET_KOPNUTI_DO_AUTOMATU;
    }

    /**
     * Tato metoda slouží k získání instance TajemnyMuz.
     *
     * @return tajemného muže
     */
    public TajemnyMuz getTajemnyMuz() {
        return tajemnyMuz;
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.put(observer, null);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((observer, o) -> observer.update());
    }
}