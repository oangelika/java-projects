public class Class extends Thread {

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println("Поток " + this.getName() + " работает.");
            }
        } catch (Exception e) {
            System.out.println("Поток " + this.getName() + " был прерван.");
        }
    }


    public Class(String name) {
        super(name);
    }
}
