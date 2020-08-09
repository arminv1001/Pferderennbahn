package Reitsport;

import Basis.Widerspruch;

/**
 * Klasse die einen Reiter erstellt mit Pferd
 * @author Armin
 */
// Pferd aus Reiter entfernen
    // PFerd nur Verein und dann Abstrakter Datentyp um die zusammenzufassen
public class Reiter extends Basis.Mensch {
    private String verein;
    public Reiter(String Name, String Vorname, int Alter, String Verein){
        super(Name, Vorname, Alter);
        verein = Verein;
    }
    public String getVerein() {
        return verein;
    }
}
