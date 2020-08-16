package Reitsport;

/**
 * Pferd wird implementiert von dem Interface PferdInt
 */
public class Pferd implements PferdInt {
    private String name;
    private String rasse;
    private String verein;
    public Pferd(String Name,  String Rasse, String Verein) {
        name = Name;
        rasse = Rasse;
        verein = Verein;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getRasse() {
        return rasse;
    }
    @Override
    public String getVerein() {
        return verein;
    }

}
