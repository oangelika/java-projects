public class Info extends Thread{


    @Override
    public void run() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                Thread.yield();
            }
            System.out.println(this.getName() + " " + i);
        }
    }

    public Info (String name){
        super(name);
    }
}
