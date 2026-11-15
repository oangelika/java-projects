public class Bird extends AbstractAnimal{

    Bird(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("sing");
    }

    public void flying(){
        System.out.println("flying");
    }



}
