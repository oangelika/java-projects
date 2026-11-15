public abstract class Employee {

    private String nick;
    private int age;
    protected int salary;


    public Employee(String nick, int age, int salary) {
        this.nick = nick;
        this.age = age;
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public abstract double bonus();


}
