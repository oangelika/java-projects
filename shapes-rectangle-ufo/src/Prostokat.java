class Prostokat extends Figura {
    private int szerokosc;
    private int wysokosc;

    public Prostokat(int x, int y, int szerokosc, int wysokosc) {
        super(x, y);
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    @Override
    public String getName() {
        return "Prostokąt";
    }

    @Override
    public void pozycja(int x, int y) {
        if (x >= this.x && x <= (this.x + szerokosc) && y >= this.y && y <= (this.y + wysokosc)) {
            System.out.println("Punkt (" + x + "," + y + ") znajduje się wewnątrz prostokąta\n");
        } else {
            System.out.println("Punkt (" + x + "," + y + ") znajduje się na zewnątrz prostokąta\n");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nLewy górny - (" + x + "," + y + ")" + "\nSzerokość: " + szerokosc
                + ", Wysokość: " + wysokosc + "\n";
    }
}
