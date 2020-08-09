package Spielorg;

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
     * Gibt zurück ob noch Platz ist für den Besucher, wenn ja dann wird er eintretten
     * @return Besucher könnte eintretten oder nicht
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
     * Besucher verlässt die Arena
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
