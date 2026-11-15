public class UFO implements Flyable, Speakable {



    @Override
    public String drive() {
        return "Antigravity";
    }

    @Override
    public double distance() {
        return 2000.0;
    }

    @Override
    public String speak(){
        return "Beep-Boop";
    }
}