public class Manager extends Employee{

    protected int amountOfProjects;

    public Manager(String nick, int age, int salary, int amountOfProjects) {
        super(nick, age, salary);
        this.amountOfProjects = amountOfProjects;
    }


    @Override
    public double bonus() {
        System.out.println("Get bonus " + (amountOfProjects * 0.1 * super.salary));
        return (amountOfProjects * 0.1 * super.salary);
    }
}
