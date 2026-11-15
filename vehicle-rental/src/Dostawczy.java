package realizacja;

public class Dostawczy extends Zamowienie {
    public Dostawczy(String nazwaSamochodu, int odleglosc) {

        super(nazwaSamochodu, TypSamochodu.DOSTAWCZY, odleglosc);
    }
}
