public class Spider implements Runnable, Knitable{

    public int legsNumber;

    public Spider(int legsNumber){
        this.legsNumber = legsNumber;
    }

    @Override
    public void run() {
        System.out.println("I can run");
    }

    @Override
    public void knit() {
        System.out.println("I can knit");
    }
}
