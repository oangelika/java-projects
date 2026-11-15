package realizacja;

public enum TypSamochodu {
    OSOBOWY("osobowy"),
    DOSTAWCZY("dostawczy"),
    ZABYTKOWY("zabytkowy"),
    DARMO("darmowy");

    private final String typ;

    TypSamochodu(String typ) {
        this.typ = typ;
    }

    // Getter for the name
    public String pobierzTyp() {
        return typ;
    }

}