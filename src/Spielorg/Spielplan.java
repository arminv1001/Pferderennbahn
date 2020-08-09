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
    //TODO Wie relevant ist durchgespielt

    public Spielplan(AnmeldeListe AnmeldeL, int Reitpaare) {
        aktReitpaare = Reitpaare;
        anmeldeListe = AnmeldeL;
        createSpielplan();
    }

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

    public void spielplanToExcel() {
        //todo
    }

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

    public int findeReitpaar( Reitpaar reitpaar) throws Widerspruch {
        for (int i = 0; i < 10; i++){
            if(spieplan[this.getRunde(reitpaar)][i].equals(reitpaar)){
                return i;
            }
        }
        throw new Widerspruch("Fehler Reitpaar wurde nciht gefunden");
    }
    public int getAnzahlRunden(){
        return spieplan.length;
    }
    //TODO hat noch fehler er printet die volle liste nicht bis dahin wo si egeht
    public void printSpielplan(){
        for(int i = 0; i < spieplan.length;i++){
            for (int j = 0; j < spieplan[0].length; j++){
                System.out.println(spieplan[i][j].getVerein());
            }
        }
    }
}