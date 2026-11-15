package realizacja;

public class InformacjaKlienta {
    private String id;
    private double kwota;
    private boolean abonament;

    public InformacjaKlienta(String id, double kwota, boolean abonament) {
        this.id = id;
        this.kwota = kwota;
        this.abonament = abonament;
    }

    public String pobierzId() {
        return id;
    }

    public double pobierzKwote() {
        return kwota;
    }

    public boolean pobierzAbonament() {
        return abonament;
    }

    public void zmienKwote(double kwota) {
        this.kwota = kwota;
    }

    public InformacjaKlienta pobierzInformacjeKlienta() {
        return this;
    }
}
