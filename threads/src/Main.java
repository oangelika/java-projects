public class Main {
    public static void main(String[] args) throws InterruptedException {

        Info info = new Info("class1");
        Info info1 = new Info("class2");
        Info info2 = new Info("class3");

        Thread thread1 = new Thread(info);
        Thread thread2 = new Thread(info1);
        Thread thread3 = new Thread(info2);

//        thread1.start();
//        thread2.start();
//        thread3.start();

//        info.start();
//        info.join();
//        info1.start();
//        info2.start();


//        Class class1 = new Class("class1");
//        Class class2 = new Class("class2");
//
//
//        class1.start();
//        class1.sleep(2000);
////        class2.start();
//        class1.interrupt();
    }
}