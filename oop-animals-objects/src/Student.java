public class Student extends AbstractStudent {

    public String name;

    public String surname;

    public int numberClass;

   @Override
   public void sayHello(){
       System.out.println("Hello, I'm student");
   }

    public Student (String name, String surname, int numberClass){
        this.name = name;
        this.surname = surname;
        this.numberClass = numberClass;
    }


}
