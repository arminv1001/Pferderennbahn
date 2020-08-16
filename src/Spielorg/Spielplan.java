package Spielorg;

import Basis.Widerspruch;
import Reitsport.Reitpaar;

import java.util.Arrays;

/**
 * Generiert einen Spielplan
 */
public class Spielplan {
    private Reitpaar[][] spieplan;
    private int aktReitpaare;
    private AnmeldeListe anmeldeListe;
    private boolean durchgespielt = false; //Wurde die Rennen schon gespielt


    public Spielplan(AnmeldeListe AnmeldeL, int Reitpaare) {
        aktReitpaare = Reitpaare;
        anmeldeListe = AnmeldeL;
        createSpielplan();
    }

    /**
     * Erstellt den Spielplan
     */
    public void createSpielplan() {
        if (!durchgespielt) {
            // Zu weniger Teilnehmer für die letzte Runde
            if ((aktReitpaare % 10) < 5 && (aktReitpaare % 10) >= 1) {
                aktReitpaare = aktReitpaare - (aktReitpaare % 10);
            }
            spieplan = new Reitpaar[aktReitpaare / 10 + 1][10];
            for (int i = 0; i < aktReitpaare / 10 + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    spieplan[i][j] = anmeldeListe.getReitpaar(j + i * 9);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Spielplan{" +
                "spieplan=" + Arrays.deepToString(spieplan) +
                '}';
    }

    public Reitpaar[][] getSpieplan() {
        return spieplan;
    }

    /**
     * Sucht nach einem Reitpaar im Spielplan
     * @param verein Verein des gescuhten Reitpaars
     * @return Reitpaar das gescuht wurde
     */
    public Reitpaar findVerein(String verein) {
        for (int i = 0; i < aktReitpaare; i++) {
            if (anmeldeListe.getReitpaar(i).getVerein().equals(verein)) {
                return anmeldeListe.getReitpaar(i);
            }
        }
        return null;
    }

    public boolean getDurchgespielt() {
        return durchgespielt;
    }

    public void setDurchgepsielt() {
        durchgespielt = true;
    }

    /**
     * Sucht, in welcher Runde sich ein Reitpaar befindet
     * @param reitpaar Das Reitpaar für dem gesucht werden soll
     * @return die Runde
     * @throws Widerspruch nicht in der Liste
     */
    public int getRunde(Reitpaar reitpaar) throws Widerspruch {
        for (int i = 0; i < aktReitpaare / 10 + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (reitpaar.equals(spieplan[i][j])) {
                    return i;
                }
            }
        }
        throw new Widerspruch("Ist nicht in Liste enthalten");
    }

    public int getAktReitpaare() {
        return aktReitpaare;
    }

    /**
     * Sucht ein Reitpaar und gibt die Nr in einer Runde zurück
     * @param reitpaar Reitpaar
     * @return Nummer in einer Runde
     * @throws Widerspruch Reiter nicht im Spiel erhalten
     */
    public int findeReitpaar( Reitpaar reitpaar) throws Widerspruch {
        for (int i = 0; i < 10; i++){
            if(spieplan[this.getRunde(reitpaar)][i].equals(reitpaar)){
                return i;
            }
        }
        throw new Widerspruch("Fehler Reitpaar wurde nicht gefunden");
    }
    public int getAnzahlRunden(){
        return spieplan.length;
    }

    /**
     * Printet den gesamten Plan
     */
    public void printSpielplan(){
        for(int i = 0; i < spieplan.length;i++){
            for (int j = 0; j < spieplan[0].length; j++){
                System.out.println(spieplan[i][j].getVerein());
            }
        }
    }
}