public abstract class AbstractAnimal {

    protected String name;

    public AbstractAnimal(String name) {
        this.name = name;

    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

}
