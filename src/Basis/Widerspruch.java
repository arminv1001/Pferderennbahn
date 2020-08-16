package Basis;

/**
 * Bei Widersprüchen in der Modellierung wird die Exception geworfen.
 * @author armin
 */
public class Widerspruch extends Exception {
    public Widerspruch() {
        super("Widerspruch");
    }
    public Widerspruch(String message) {
        super("Widerspruch: " + message);
    }
}
