public class Animal {

    public String animalType;
    public String color;
    public int age;

    public Animal (String animalType, String color, int age){
        this.animalType = animalType;
        this.color = color;
        this.age = age;

    }
    public void animalSay (){
        System.out.println("Hello, I'm " + this.animalType);
    }
}
