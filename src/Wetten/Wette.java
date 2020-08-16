package Wetten;

import Besucher.Zuschauer;
import Reitsport.Reitpaar;

/**
 * Wette
 *
 * @author armin
 */
public class Wette {
    private Zuschauer zuschauer;
    private Reitpaar reitpaar;
    private double betrag;
    private boolean eingeloest;
    private int id;
    private int runde;

    public Wette(Zuschauer zuschauer, Reitpaar reitpaar, double betrag, WettID wettID, int pot) {
        this.zuschauer = zuschauer;
        this.reitpaar = reitpaar;
        this.betrag = betrag;
        this.eingeloest = false;
        wettID.WettIdIncrease();
        this.id = wettID.getAnzahl();
        this.runde = pot;
    }

    public Zuschauer getZuschauer() {
        return zuschauer;
    }

    public Reitpaar getReitpaar() {
        return reitpaar;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setEingeloest() {
        this.eingeloest = true;
    }

    public boolean getEingeloest() {
        return eingeloest;
    }

    public int getId() {
        return id;
    }

    public int getRunde() {
        return runde;
    }
}
