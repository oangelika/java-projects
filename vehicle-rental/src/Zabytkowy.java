package realizacja;

public class Zabytkowy extends Zamowienie {
    public Zabytkowy(String nazwaSamochodu, int odleglosc) {
        super(nazwaSamochodu, TypSamochodu.ZABYTKOWY, odleglosc);
    }
}
