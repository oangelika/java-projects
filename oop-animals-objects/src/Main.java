public class Main {
    public static void main(String[] args) {

//        Human ivan = new Human();
//        System.out.println(ivan.getName());
//
//        Human piotr = new Human("piotr", 19, 180);
//        System.out.println(piotr.getName());
//
//        piotr.sayHello();
//
//        piotr.setName("vova");
//
//        piotr.sayHello();


//        Car toyota = new Car("toyota", 2.5, 20000 );
//        System.out.println(toyota.getBrand());
//
//        System.out.println(toyota.getMillage());
//
//        toyota.drive();
//        System.out.println(toyota.getMillage());


//        Animal tiger = new Animal("tiger", "orange", 13 );
//        System.out.println(tiger.animalType);
//        System.out.println(tiger.color);
//        System.out.println(tiger.age);
//
//        tiger.animalSay();


        Device d = new Device(160,13);
//
//        d.devicePrint();
//
        Laptop l = new Laptop(120, 16);
//
//        l.devicePrint();

//        l.uselaptop();
//        l.uselaptop();
//        l.uselaptop();
//        System.out.println(l.batteryPower);

        Laptop l2 = new Laptop(140,13);
//
//        l2.uselaptop();
//        System.out.println(l2.batteryPower);
//
//        System.out.println(l2.cpuFr);

        l2.screenDiagonal = 5;

        d.getInfo();
        l.getInfo();
//
        System.out.println(l2.screenDiagonal);


//        try {
//            int a = -5;
//            if (a < 0) {
//                throw new Exception("a should be positive");
//
//            }
//            System.out.println("It's ok");
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
//        }


//        Complex a = new Complex (3,8);
//
//        a.printComplex();
//
//        Complex b = new Complex (1,5);
//
//        b.printComplex();
//
//        Complex sum = a.sum(b);
//
//        sum.printComplex();
//
//        Complex sub = b.sub(a);
//
//        sub.printComplex();
//
//        Complex multi = a.multi(b);
//
//        multi.printComplex();
//
//        Complex div = a.div(b);
//
//        div.printComplex();
//
//        System.out.println(a.rSum(b.ReZ));


//        Table table = new Table("steel");
//
//        table.bePlased();
//


//        Student piotr = new Student("piotr", "vasiljev", 113);
//
//        piotr.sayHello();


//        LectionRoom inf = new LectionRoom(345);
//
//        inf.getNumber();


//        PractiseRoom my = new PractiseRoom(20);
//
//        my.numberComputerOn();
//
//        my.numberComputerOff();


//        Spider spider = new Spider(8);
//        spider.run();
//        spider.knit();



        Rabbit firstRabbit = new Rabbit();
        Rabbit secondRabbit = new Rabbit();
        Rabbit thirdRabbit = new Rabbit();
        Rabbit fourthRabbit = new Rabbit();
        Rabbit fifthRabbit = new Rabbit();
        System.out.println(secondRabbit.count);

    }
}
