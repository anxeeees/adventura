package cz.vse.stae07.UI;

import java.util.Scanner;

import cz.vse.stae07.logika.Hra;

/**
 * Třída TextoveRozhrani - slouží k vytvoření a zajištění textového rozhraní pro herní aplikaci.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public class TextoveRozhrani {
    public Hra hra;

    /**
     * Konstuktor TextoveRozhrani - slouží k vytvoření hry.
     *
     * @param hra, propojuje instanci třídy TextoveRozhrani se zadanou herní instancí
     */
    public TextoveRozhrani(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda slouží k spuštění a provádění příkazů a hraní.
     * Vypíše úvodní zprávu pro hráče a umožňuje nastavení vlastního jména.
     * Dokud hra neskončila, hráč může zadávat příkazy.
     */
    public void hraj() {
        Scanner scanner = new Scanner(System.in);
        String prikaz;
        String tvojeJmeno;
        String uvod = "Začínáš na ulici v osmdesátkách před klubem The Saint. Jsi policista " +
                "v utajení. Za poslední 3 týdny se tu událo hodně vražd a tvým úkolem" +
                " je zjistit, kdo je vrah. \n\n" +
                "Saháš do peněženky a kontroluješ, jestli sis nezapomněl svoji falešnou občanku. Na občance je napsáno jméno: \"";
        System.out.println(uvod);
        tvojeJmeno = scanner.nextLine();
        hra.getHerniSvet().setTvojeJmeno(tvojeJmeno);
        System.out.println(tvojeJmeno + "? Horší jméno mi vybrat nemohli. ");
        while (!hra.isHraSkoncila()) {
            prikaz = scanner.nextLine();
            String odpoved = hra.zpracujPrikaz(prikaz);
            System.out.println(odpoved + "\n");
        }
    }
}
