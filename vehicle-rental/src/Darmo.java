package realizacja;

import specyfikacji.ListaZyczenSpec;

public class Darmo extends Zamowienie {

    public Darmo(String nazwaSamochodu, int odleglosc) {
        super(nazwaSamochodu, TypSamochodu.DARMO, odleglosc);
        ListaZyczenSpec.adjustFreeDistance.apply(this);
    }
}


