public class Mammal extends AbstractAnimal{

    Mammal(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("rrr");
    }

    public void walking(){
        System.out.println("walking");
    }

    @Override
    public String toString() {
        return "Mammal " + name;
    }
}
