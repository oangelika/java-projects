package realizacja;

import specyfikacji.ListaZyczenSpec;

import java.util.HashMap;
import java.util.Map;

public abstract class ListaWzorzec {
    private Map<String, Zamowienie> lista;
    private InformacjaKlienta klient;

    public ListaWzorzec(InformacjaKlienta klient) {
        this.klient = klient;
        lista = new HashMap<>();
    }

    public void dodaj(Zamowienie zamowienie) {
        lista.put(zamowienie.pobierzNazweSamochodu(), zamowienie);
    }

    public Zamowienie usun(Zamowienie car) {
        return lista.remove(car.pobierzNazweSamochodu());
    }

    public Map<String, Zamowienie> pobierzListe() {
        return lista;
    }

    public InformacjaKlienta pobierzKlienta() {
        return klient;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(klient.pobierzId() + ":\n");
        if (lista.isEmpty())
            return sb.append("-- pusto\n").toString();
        lista.forEach((k, v) -> sb.append(ListaZyczenSpec.wishDisplay(v, klient))); ///
        return sb.toString();
    }

    public void merge(Zamowienie zamowienie) {
        lista.merge(zamowienie.pobierzNazweSamochodu(), zamowienie, Zamowienie::merge);
    }
}
