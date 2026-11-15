public class Main {
    public static void main(String[] args) {

//        Manager manager = new Manager("Fiodor", 23,"Sovetskaya", 78);
//        Manager manager1 = new Manager("Piotor", 25,"Gogolya", 45);
//
//        manager.SayHello();
//
//        System.out.println();
//
//        manager1.SayHello();
//
//        System.out.println();
//
//
//        Bicycle bicycle = new Bicycle(2, 60, "kid");
//        Car car = new Car(4,300, 400,10);
//        Bus bus = new Bus(4,200,51);
//
//        bicycle.drive();
//        car.drive();
//        bus.drive();


//        Plane plane = new Plane(150,500);
//        plane.fly();
//
//
//        Flyable flyer = new Flyable() {
//            @Override
//            public void fly() {
//                System.out.println("I am flying");
//            }
//        };
//
//        flyer.fly();
//

        Seasons seasons = Seasons.SPRING;

        System.out.println(seasons);
        System.out.println(seasons.getSeasonName());
        System.out.println(seasons.name());

        Seasons winter = Seasons.valueOf("WINTER");
        System.out.println(winter.getTemperature());

//
//        Rabbit rabbit = new Rabbit(4,"white", "Steve");
//        rabbit.voice();
//        System.out.println(rabbit.getName());




    }
}