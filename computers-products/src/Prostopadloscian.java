class Prostopadloscian extends Prostokat {
    private double wysokosc;

    public Prostopadloscian(double dlugosc, double szerokosc, double wysokosc) {
        super(dlugosc, szerokosc);
        this.wysokosc = wysokosc;
    }

    public double obliczObjetosc() {
        return obliczPolePowierzchni() * wysokosc;
    }
}