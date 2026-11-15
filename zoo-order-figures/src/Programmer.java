public class Programmer extends Employee{

    protected boolean plan;

    public Programmer(String nick, int age, int salary, boolean plan) {
        super(nick, age, salary);
        this.plan = plan;
    }


    @Override
    public double bonus(){
        System.out.println(plan ? "Get bonus " + (super.salary * 0.2) : "No bonus " );
        return plan ? (super.salary * 0.2) : 0.0;
    }
}
