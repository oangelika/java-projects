package realizacja;

public class Osobowy extends Zamowienie {
    public Osobowy(String nazwaSamochodu, int odleglosc) {
        super(nazwaSamochodu, TypSamochodu.OSOBOWY, odleglosc);
    }

}
