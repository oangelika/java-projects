class Trojkat {
    private double bok;

    public Trojkat(double bok) {
        this.bok = bok;
    }

    public double obliczPolePowierzchni() {
        return (Math.sqrt(3) / 4) * bok * bok;
    }
}


