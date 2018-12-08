package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Laskutoimitus implements Komento {

    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int arvoEnnenSuoritusta;

    public Laskutoimitus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        int arvo = 0;
        arvoEnnenSuoritusta = sovellus.tulos();

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        syotekentta.setText("");
        laske(arvo);
        tuloskentta.setText("" + sovellus.tulos());

        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }

        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + arvoEnnenSuoritusta);
        sovellus.aseta(arvoEnnenSuoritusta);
        syotekentta.setText("");
        undo.disableProperty().set(true);
    }

    protected abstract void laske(int arvo);
}
