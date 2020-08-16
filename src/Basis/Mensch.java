package Basis;

/**
 * Diese abstrakte Klasse "Mensch" soll einen Menschen mit seinem Vor- und Nachnamen, sowie seinem Alter definieren.
 * @author Armin
 */
abstract public class Mensch {
    private String name;
    private String vorname;
    private int alter;
    public Mensch(String Name, String Vorname, int Alter) {
        name = Name;
        vorname = Vorname;
        alter = Alter;
    }
    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public int getAlter() {
        return alter;
    }
}
