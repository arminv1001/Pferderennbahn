package Basis;

public class Widerspruch extends Exception {
    public Widerspruch() {
        super("Widerspruch");
    }
    public Widerspruch(String message) {
        super("Widerspruch: " + message);
    }
}
