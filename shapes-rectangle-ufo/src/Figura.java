abstract class Figura {
    protected int x;
    protected int y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract String getName();

    public abstract void pozycja(int x, int y);

    @Override
    public String toString() {
        return getName() + "\nŚrodek - (" + x + "," + y + ")";
    }
}