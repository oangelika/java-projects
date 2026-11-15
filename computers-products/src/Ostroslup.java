class Ostroslup extends Trojkat {
    private double wysokosc;

    private double bok;

    public Ostroslup(double bok, double wysokosc) {
        super(bok);
        this.bok = bok;
        this.wysokosc = wysokosc;
    }

    public double obliczObjetosc() {
        return (Math.sqrt(3) / 12) * bok * bok * wysokosc;
    }
}
