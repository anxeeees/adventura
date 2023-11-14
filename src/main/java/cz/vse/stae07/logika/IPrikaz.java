package cz.vse.stae07.logika;

/**
 * Třída IPrikaz - slouží ke zpracování příkazu ve hře.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */
public interface IPrikaz {

    /**
     * Tato metoda vrací název příkazu.
     *
     * @return název příkazu
     */
    public String getNazev();

    /**
     * Tato metoda slouží k provedení příkazu ve hře.
     * Počet parametrů je závislý na konkrétním příkazu.
     *
     * @param parametry, počet parametrů
     */
    public String proved(String[] parametry);


}
