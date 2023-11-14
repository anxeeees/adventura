package cz.vse.stae07.logika.prikazy;

import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.IPrikaz;

/**
 * Třída PrikazOznac - implementuje pro hru příkaz oznac.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class PrikazOznac implements IPrikaz {

    private Hra aktualniHra;

    /**
     * Konstruktor třídy.
     *
     * @param aktualniHra, odkaz na hru, ve které má být příkaz proveden
     */
    public PrikazOznac(Hra aktualniHra) {
        this.aktualniHra = aktualniHra;
    }

    /**
     * Získá název příkazu.
     *
     * @return příkaz, který se zadává do hry a je platný
     */
    @Override
    public String getNazev() {
        return "oznac";
    }

    /**
     * Provede označení vraha a vypsání textu po označení.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return text výsledku příkazu
     */
    @Override
    public String proved(String[] parametry) {
        HerniSvet svet = aktualniHra.getHerniSvet();
        String jmenoPostavy = String.join(" ", parametry);

        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Kdo je vrahem? Musíš někoho označit.";
        }

        aktualniHra.setHraSkoncila(true);

        if (jmenoPostavy.equalsIgnoreCase(svet.getTvojeJmeno())) {
            return "Haha! No to se ti povedlo. Geniální!" +
                    " Chvíli trvalo, než ti to došlo." +
                    "\nAle chápu. Být psychicky labilní a myslet si, že děláš nějaký dobro..." +
                    " Drogy dělaj hodně. " +
                    "\nKaždopádně škoda, že jsi musel zabít toho novináře. Začínal se mi libit. Budu na tebe myslet, až budeš" +
                    " v lochu.";
        }
        return "Holt ti to nevyšlo. Asi bych měl bejt lepší v nápovědách." +
                "\nChudák odsouzená osoba teď sedí v lochu, zatímco vrah si tu pořád někde lítá." +
                "\nJaká to smutná zpráva. Muhahah!!!";
    }
}
