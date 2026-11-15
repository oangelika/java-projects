class Kolo extends Figura {
    private int radius;

        public Kolo(int x, int y, int radius) {
            super(x, y);
            this.radius = radius;
        }

        @Override
        public String getName() {
            return "Koło";
        }
@Override
public void pozycja(int x, int y) {
    double odleglosc = Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
    if (odleglosc <= radius) {
        System.out.println("Punkt (" + x + "," + y + ") znajduje się wewnątrz koła\n");
    } else {
        System.out.println("Punkt (" + x + "," + y + ") znajduje się na zewnątrz koła\n");
    }
}

@Override
public String toString() {
    return super.toString() + "\nPromień - " + radius + "\n";
        }
}

