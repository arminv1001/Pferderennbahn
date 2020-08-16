package Besucher;

import Basis.Mensch;
import Basis.Systemfehler;
import Basis.Widerspruch;
import Spielorg.Arena;
import Wetten.Beleg;

/**
 * Die Klasse Zuschauer ist ein Mensch, welcher sich die Spiele anschauen kann und Wetten auf die Pferde setzen kann
 * @author armin
 */
public class Zuschauer extends Mensch {
    private double kontostand;
    private Arena standort;
    private BelegListe belegListe;

    public Zuschauer(String Name, String Vorname, int Alter, double Kontostand) throws Widerspruch {
        super(Name, Vorname, Alter);
        if (Kontostand < 0) {
            throw new Widerspruch("Kontostand kann nicht kleiner als 0 sein");
        }
        kontostand = Kontostand;
        standort = null;
        belegListe = new BelegListe();
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double Kontostand) throws Widerspruch {
        if (Kontostand < 0) {
            throw new Widerspruch("Kontostand kann nicht kleiner als 0 sein");
        }
        this.kontostand = Kontostand;
    }

    /**
     * Zuschauer probiert in die Arena a einzutretten und bekommt über die Konsole ein Feedback, ob dies funktioniert hat
     * @param a Arena
     * @pre Konto von Zuschauer ist gößer als 5€
     */
    public void arenaBesuchen(Arena a) {
        if(this.kontostand >= 5) {
            if (a.neuerBesucher()) {
                standort = a;
                this.kontostand -= 5;
            } else {
                System.out.println("Stadion ist voll");
            }
        }
    }

    /**
     * Zuschauer verlässt die Arena, in welcher er sich gerade befindet
     * @throws Widerspruch falls er sich gerade in keiner Arena befindet
     * @throws  Systemfehler Fehler
     * @post nach der Methode ist der Standort des Zuschauer gleich Null
     */
    public void arenaVerlassen() throws Widerspruch, Systemfehler {
        if (standort == null) {
            throw new Widerspruch("Zuschauer befindet sich in keiner Arena");
        } else {
            if (standort.besucherVerlassen())
                standort = null;
            else
                throw new Systemfehler("Fehler");
        }
    }

    /**
     * Platziert eine Wette beim Wettbuero
     *
     * @param verein Verein des Reitpaars
     * @param geld Betrag mit dem gewettet wird
     * @return gibt zurück ob die Wette gesetzt werden konnte
     * @throws Widerspruch Falls der Zuschauer sich nicht in einer Arena befindet kann er auch keine Wetten setzen
     * @throws Systemfehler Systemfehler in Wettbuero.setWette(...)
     */
    public boolean setWette(String verein, double geld) throws Systemfehler, Widerspruch {
        if (this.kontostand - geld >= 0) {
            if(standort == null){
                throw new Widerspruch("Benutzer hat kein Standort");
            }
            Beleg b =  standort.getWettbuero().setWette(verein, geld, this);
            kontostand = kontostand - geld;
            belegListe.add(b);
            return true;
        } else
            return false;

    }

    /**
     * Beleg aus der Belegliste mit dem Index index wird eingelöst
     * @param index Stelle in der BelegListe
     * @throws Widerspruch Bereichsüberschreitung ind er Liste
     */
    public void einloesen(int index) throws Widerspruch {
        if(index < belegListe.getSize()){
            kontostand = kontostand + standort.getWettbuero().einloesenWette(belegListe.get(index));
            belegListe.delete(index);
        } else
            System.out.println("Diesen Beleg gibt es nicht");
    }

    public Arena getStandort() {
        return standort;
    }

    /**
     * Beleg in der BelegListe an der Stelle index
     * @param index Position in der Liste
     * @return gibt den Beleg zurück
     * @throws Widerspruch wirft einen Widerspruch aufgrund von einer Bereichsüberschreitung
     */
    public Beleg getBeleg(int index) throws Widerspruch {
        if(index < belegListe.getSize())
            return belegListe.get(index);
        else
            throw new Widerspruch("Bereichsüberschreitung");
    }

}
