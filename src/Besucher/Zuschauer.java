package Besucher;

import Basis.Mensch;
import Basis.Systemfehler;
import Basis.Widerspruch;
import Spielorg.Arena;
import Wetten.Beleg;

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

    public void arenaBesuchen(Arena a) {
        if (a.neuerBesucher()) {
            standort = a;
        } else {
            System.out.println("Stadion ist voll");
        }
    }

    public void arenaVerlassen() throws Widerspruch {
        if (standort == null) {
            throw new Widerspruch("Zuschauer befindet sich in keiner Arena");
        } else {
            if (standort.besucherVerlassen())
                standort = null;
            else
                throw new Widerspruch("Fehler Arena Zähler");
        }
    }

    /**
     * Platziert eine Wette beim Wettbuero
     *
     * @param verein
     * @param geld
     * @return
     * @throws Widerspruch
     */
    public boolean setWette(String verein, double geld) throws Systemfehler, Widerspruch {
        if (this.kontostand - geld >= 0) {
            if(standort == null){
                throw new Widerspruch("Benutzer hat kein Standort");
            }
            Beleg b =  standort.getWettbuero().setWette(verein, geld, this);
            System.out.println("EINGABE " + b.getEingabe());
            kontostand = kontostand - geld;
            belegListe.add(b);
            return true;
        } else
            return false;

    }

    /**
     * falls Beleg nicht eingelöst werden kann dann wird false zurück gegeben
     *
     * @param index
     * @return
     */
    public void einloesen(int index) throws Widerspruch {
        kontostand = kontostand + standort.getWettbuero().einloesenWette(belegListe.get(index));
        belegListe.delete(index);
    }

    public Arena getStandort() {
        return standort;
    }

    public Beleg getBeleg(int index){
        return belegListe.get(index);
    }

}
