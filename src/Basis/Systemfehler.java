package Basis;

public class Systemfehler extends Exception {
    public Systemfehler() {
        super("Systemfehler");
    }
    public Systemfehler(String message) {
        super("Systemfehler: " + message);
    }
}