public class Plane implements Flyable, Speakable {
    @Override
    public String drive() {
        return "Lot";
    }

    @Override
    public double distance() {
        return 400.0;
    }

    @Override
    public String speak() {
        return "Wr-r-r";
    }

}
