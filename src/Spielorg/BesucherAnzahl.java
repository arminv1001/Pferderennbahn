package Spielorg;

/**
 * Die Klasse managt die Besucher und deren Anzahl für eine Arena.
 * @author armin
 */
public class BesucherAnzahl {
    private int anzahl;
    private final int MAX_ANZAHL;

    public BesucherAnzahl( int MAX_ANZAHL) {
        this.anzahl = 0;
        this.MAX_ANZAHL = MAX_ANZAHL;
    }

    public int getAnzahl() {
        return anzahl;
    }
    /**
     * Gibt zurück, ob der Besucher eintreten konnte
     * @return Besucher konnte eintreten oder nicht
     */
    public boolean setAnzahlInc() {
        if(MAX_ANZAHL >= anzahl + 1) {
            this.anzahl = anzahl + 1;
            return true;
        }
        else
            return false;
    }

    /**
     * Anzahl wird Dec
     * @return true, wenn es funktioniert hat
     */
    public boolean setAnzahlDec() {
        if(anzahl > 0 )
            this.anzahl = anzahl - 1;
        else
            return false;
        return true;
    }

    public int getMAX_ANZAHL() {
        return MAX_ANZAHL;
    }
}
