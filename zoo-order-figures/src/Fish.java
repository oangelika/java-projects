public class Fish extends AbstractAnimal{


    Fish(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("bubble");
    }

    public void swimming(){
        System.out.println("swimming");
    }
}
