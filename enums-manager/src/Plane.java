public class Plane implements Flyable{

    private int lengh;
    private int speed;

    public Plane(int lengh, int speed) {
        this.lengh = lengh;
        this.speed = speed;
    }

    public int getLengh() {
        return lengh;
    }

    public void setLengh(int lengh) {
        this.lengh = lengh;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void fly() {
        System.out.println("Plane flying");
    }
}
