public class Human {

    private String name;
    public int age;
    public int height;

    public Human (){
        this.name = "Name";
        this.age = 19;
        this.height = 180;

    }
    public Human (String name, int age, int height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName (){
        return this.name;
    }

    public void sayHello (){
        System.out.println("Hello, I'm " + this.name);
    }

    public void setName (String name){
        this.name = name;
    }
}

