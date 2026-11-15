public class Zoo {

    private AbstractAnimal[] animals = new AbstractAnimal[10];
    private int counter = 0;

    public void addAnimal(AbstractAnimal animal) {
        if (counter == animals.length) {
            System.out.println("no place");
        }
        animals[counter++] = animal;
    }

    private AbstractAnimal recursion(String name, int index) {
        if (index >= counter) {
            return null;
        }
        if (animals[index].getName().equals(name)) {
            return animals[index];
        }
        return recursion(name, index + 1);
    }

    public AbstractAnimal findAnimal(String name) {
        return recursion(name, 0);
    }

    public void listOfAllAnimals() {
        if (animals.length == 0) {
            System.out.println("no animals");
        } else {
            for (int i = 0; i < counter; i++) {
                System.out.print(animals[i].getName() + " make sound ");
                animals[i].makeSound();
                System.out.println();
            }
        }

    }
}
