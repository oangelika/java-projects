public class Rabbit extends Animal{

    private String name;

    public Rabbit(int legs, String color, String name){
        super(legs, color);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void voice(){
        System.out.println("Rabbit voice");
    }
}
