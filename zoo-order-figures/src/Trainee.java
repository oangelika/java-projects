public class Trainee extends Employee{

    protected int days;

    public Trainee(String nick, int age, int salary, int days) {
        super(nick, age, salary);
        this.days = days;
    }


    @Override
    public double bonus(){
        System.out.println(days >= 30 ? "Get bonus " + super.salary * 0.1 : "No bonus");
        return days >= 30 ? super.salary * 0.1 : 0.0;
    }
}
