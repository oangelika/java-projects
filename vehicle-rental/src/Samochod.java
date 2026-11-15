package realizacja;

public class Samochod {
    private String nazwaSamochodu;
    private TypSamochodu typSamochodu;

    protected Samochod(String nazwaSamochodu, TypSamochodu typSamochodu) {
        this.nazwaSamochodu = nazwaSamochodu;
        this.typSamochodu = typSamochodu;
    }

    public String pobierzNazweSamochodu() {
        return nazwaSamochodu;
    }

    public TypSamochodu pobierzTypSamochodu() {
        return typSamochodu;
    }
}
