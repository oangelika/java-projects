public abstract class Animal {

    private int legs;
    private String color;

    public Animal(int legs, String color) {
        this.legs = legs;
        this.color = color;
    }

    public int getLegs() {
        return legs;
    }

    public String getColor() {
        return color;
    }


    public abstract void voice();

}
