package Wetten;

/**
 * Kümmert sich um die ID von einer Wette und zählt die Anzahl an Wetten
 */
public class WettID {
    private int anzahl = 0;

    public WettID() {
    }

    /**
     * Erhöht den Wert von Anzahl
     */
    public void WettIdIncrease() {
        this.anzahl = this.anzahl + 1;
    }

    public int getAnzahl() {
        return anzahl;
    }
}
