package Basis;

/**
 * Wir bei System/Programfehlern geworfen.
 * @author armin
 */
public class Systemfehler extends Exception {
    public Systemfehler(String message) {
        super("Systemfehler: " + message);
    }
}