package realizacja;

public abstract class Zamowienie extends Samochod implements Cloneable {
    private int odleglosc;

    protected Zamowienie(String nazwaSamochodu, TypSamochodu typSamochodu, int odleglosc) {
        super(nazwaSamochodu, typSamochodu);
        this.odleglosc = odleglosc;
    }

    public int pobierzOdleglosc() {
        return odleglosc;
    }

    public void zmienOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }

    @Override
    public Zamowienie clone() throws CloneNotSupportedException {
        return (Zamowienie) super.clone();
    }

    public Zamowienie merge(Zamowienie zamowienie) {
        this.odleglosc += zamowienie.pobierzOdleglosc();
        return this;
    }
}
