package cz.vse.stae07.gui;


import cz.vse.stae07.logika.HerniSvet;
import cz.vse.stae07.logika.Hra;
import cz.vse.stae07.logika.Lokace;
import cz.vse.stae07.observer.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Třída HerniPlocha představuje herní plochu, kde se zobrazuje grafická reprezentace adventury.
 *
 * @author Ester Stankovská
 * @version pro školní rok 2022/2023
 */

public class HerniPlocha implements Observer {

    private HerniSvet herniSvet = Hra.getSingleton().getHerniSvet();
    private AnchorPane anchorPane = new AnchorPane();
    private Circle aktualniPozice = new Circle(10.0, Paint.valueOf("RED"));

    private ImageView imageView;

    /**
     * Konstruktor pro vytvoření herní plochy s výchozím nastavením.
     */
    public HerniPlocha() {
        Image image = new Image(HerniPlocha.class.getClassLoader().getResourceAsStream("herniPlan.png"), 480, 300,
                false, false);
        imageView = new ImageView(image);

        anchorPane.getChildren().addAll(imageView, aktualniPozice);
        AnchorPane.setLeftAnchor(imageView, 200.0);
        nastavPoziciHrace();
        herniSvet.registerObserver(this);
    }

    /**
     * Konstruktor pro vytvoření herní plochy s předaným herním světem.
     *
     * @param svet, který má být zobrazen na herní ploše.
     */

    public HerniPlocha(HerniSvet svet) {
        this.herniSvet = svet;
        herniSvet.registerObserver(this);

    }

    /**
     * Metoda slouží k získání reference na objekt typu AnchorPane, který představuje herní plochu.
     *
     * @return Reference na herní plochu jako objekt typu AnchorPane.
     */

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    /**
     * Metoda slouží k aktualizaci stavu herní plochy na základě změn v herním světě.
     * Po volání této metody je herní plocha aktualizována tak, aby odražovala aktuální stav hry.
     */
    @Override
    public void update() {
        nastavPoziciHrace();
    }

    /**
     * Metoda slouží k nastavení pozice hráče na herní ploše na základě aktuální lokace hráče.
     * Tato metoda je volána po změně aktuální lokace hráče pro aktualizaci jeho pozice na herní ploše.
     */

    private void nastavPoziciHrace() {
        Lokace aktualniLokace = herniSvet.getAktualniLokace();
        AnchorPane.setLeftAnchor(aktualniPozice, aktualniLokace.getPosLeft());
        AnchorPane.setTopAnchor(aktualniPozice, aktualniLokace.getPosTop());

    }


}
