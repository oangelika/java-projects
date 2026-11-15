class Graniastoslup extends Trojkat {
    private double wysokosc;

    private double bok;

    public Graniastoslup(double bok, double wysokosc) {
        super(bok);
        this.bok = bok;
        this.wysokosc = wysokosc;
    }

    public double obliczObjetosc() {
        return (Math.sqrt(3) / 6) * bok * bok * wysokosc;
    }
}
