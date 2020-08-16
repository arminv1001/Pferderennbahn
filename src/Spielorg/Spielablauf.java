package Spielorg;

import Basis.Widerspruch;
import Reitsport.Reitpaar;

import java.util.Random;

/**
 * Spielt die Spiele und gibt die Resultate zurück
 *
 * @author armin
 */
public class Spielablauf {
    private Reitpaar[][] spielplan;

    public Spielablauf(Spielplan Sp1) throws Widerspruch {
        if (Sp1 == null)
            throw new Widerspruch("Spieplan ist leer");
        spielplan = Sp1.getSpieplan();
        werteSiegerAus();
    }

    /**
     * Läuft durch das Array und spielt jedes Spiel
     */
    private void werteSiegerAus() {
        for (int i = 0; i < spielplan.length; i++) {
            spielplan[i] = spielSpielen(spielplan[i]);
        }
    }

    public Reitpaar getSieger(int reihe) {
        return spielplan[reihe][0];
    }

    /**
     * Sortiert die Spiele zufällig um und gibt die ersten 3 Plätze aus
     *
     * @param reitpaar Einzelnes Spiel
     * @return Fertig gespieltes Spiel wird mit der jeweiligen Platzierung zurückgegeben
     */
    private Reitpaar[] spielSpielen(Reitpaar[] reitpaar) {
        reitpaar = randomGewinner(reitpaar);
        for (int i = 0; i < 3; i++) {
            System.out.println((i+1) + ".Platz" + ": "  + reitpaar[i].getReiter().getVerein());
        }
        return reitpaar;
    }

    /**
     * Reiter in einer Runde
     *
     * @param reitpaar Reitpaar in einer Runde
     * @return Anzahl
     */
    private int getAnzahlReiter(Reitpaar[] reitpaar) {
        int j = 0;
        while (j < 10 && reitpaar[j] != null) {
            j++;
        }
        return j;
    }

    public Reitpaar[][] getSpielplanFertigGespielt() {
        return spielplan;
    }

    /**
     * Siegerliste
     * @param reitpaar Einzelne Runde
     * @return Platzierungsliste
     */
    private Reitpaar[] randomGewinner(Reitpaar[] reitpaar) {
        int random;
        Reitpaar[] tmpArrray = new Reitpaar[getAnzahlReiter(reitpaar)];

        Random r = new Random();
        for (int i = 0; i < getAnzahlReiter(reitpaar); i++) {
            random = r.nextInt(getAnzahlReiter(reitpaar));
            while (tmpArrray[random] != null) {
                if (random >= getAnzahlReiter(reitpaar) - 1) {
                    random = 0;
                } else
                    random++;
            }
            tmpArrray[random] = reitpaar[i];
        }
        return tmpArrray;
    }
}
