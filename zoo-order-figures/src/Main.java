import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {





//
//        Triangle triangle = new Triangle(12,3,6);
//        System.out.println(triangle.getArea());
//
//
//
//        function();
//        int result = sum(2,6);
//        System.out.println(result);
//
//
//
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(arr.toString());
//        System.out.println(arr[4]);
//        System.out.println(arr.length);
//        System.out.println();
//
//        int[][] arr2 = new int[2][2];
//        arr2[0][0] = 1;
//        arr2[0][1] = 2;
//
//        arr2[1][0] = 3;
//        arr2[1][1] = 4;
//
//        for (int i = 0; i < arr2.length; i++) {
//            for (int j = 0; j < arr2[i].length; j++) {
//                System.out.print(arr2[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//
//        int a = 0;
//        while (a < arr.length) {
//            System.out.println(arr[a]);
//            ++a;
//
//        }
//        System.out.println();
//
//
//        for (int el : arr) {
//            System.out.println(el);
//
//        }
//
//        System.out.println();
//
//
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            System.out.println(arr[i]);
//
//        }
//
//
//
//    }
//
//
//    public static void function(){
//        System.out.println("Hello World");
//    }
//
//
//    public static int sum(int a, int b){
//        return a + b;


//        Person person = new Person("Vanya", "Ivanov", 23);
//        person.getData();
//        person.setAge(25);
//        person.getData();
//
//
//        Animal cat = new Cat("Barsik");
//        Animal dog = new Dog("Bob");
//        cat.makeSound();
//        dog.makeSound();


//        Circle circle = new Circle(5);
//        System.out.println(circle.square());
//        System.out.println(circle.perimeter());
//

//        Pers<String, Long> pers1 = new Pers<>("87", 23L);
//        Pers<Integer, Integer> pers2 = new Pers<>(87,21);
//
//        System.out.println(pers1);
//        System.out.println(pers2);


//        String str = "teret";
//        System.out.println(str.length());
//        System.out.println(str.toUpperCase());
//        String newSTR = "Practising strings with teacher";
//        System.out.println(newSTR.split("\\s").length);
//        System.out.println(newSTR.replace(' ', ','));

//        for (int i = 0; i < str.length()/2; i++) {
//            if (str.charAt(i) != str.charAt(str.length()-i-1)){
//                System.out.println(false);
//            }
//        }
//        System.out.println(true);


//        String let = "aaabbcccccnnneeeeee";
//        StringBuilder result = new StringBuilder();
//        int count = 1;
//        for (int i = 1; i < let.length(); i++) {
//            if (let.charAt(i) == let.charAt(i - 1)){
//                count++;
//            } else {
//                result.append(let.charAt(i - 1)).append(count);
//                count = 1;
//            }
//        }
//        result.append(let.charAt(let.length() - 1)).append(count);
//        System.out.println(result);


//        List<Order> orders = new ArrayList<>(Arrays.asList(
//                new Order("Ivan", LocalDate.of(2023, 4, 12)),
//                new Order("Alex", LocalDate.of(2023, 5, 2)),
//                new Order("Stanislav", LocalDate.of(2023, 12, 11)),
//                new Order("Nick", LocalDate.of(2023, 7, 18)),
//                new Order("Michal", LocalDate.of(2023, 6, 21))
//                ));
//
//
//        List<String> result = orders.stream()
//                .sorted(Comparator.comparing(Order::getOrderedDate).reversed())
//                .limit(3)
//                .map(Order::getCostumerName)
//                .collect(Collectors.toList());
//
////        result.stream().forEach(el -> System.out.println("Customer:" + el));
//
//        for (String name : result){
//            printName(name);
//        }
//    }
//
//
//    public static void printName(String name){
//        System.out.println("Customer: " + name);


//        List<Integer> arr = new ArrayList<>();
//        arr.addAll(List.of(5,7,8,1,3,12,13,14,15));
//        System.out.println(test(arr));
//
//    }
//
//    public static List<Integer> test(List<Integer> arr) {
//        if (arr.isEmpty()) {
//            return new ArrayList<>();
//        }
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i) % 2 == 1) {
//                arr.remove(i);
//                i--;
//            }
//        }
//        return arr;
//    }


        List<Integer> list = new ArrayList<>(List.of(-1,2,54,106,-398,21,16,-532,5,-1,0,54));
//        list.stream()
//                .filter(el -> el > 0)
//                    .forEach(System.out::println);

//        list.stream()
//                .map(el -> el * 2)
//                    .forEach(System.out::println);

//        list.stream()
//                .sorted()
//                    .forEach(System.out::println);

//        System.out.println();
//
//        list.stream()
//                .sorted((el1, el2) -> el1 > el2 ? -1 : el1 < el2 ? 1 : 0)
//                    .forEach(System.out::println);

//        list.stream()
//                .sorted()
//                .limit(3)
//                .map(el -> el * -1)
//                .forEach(System.out::println);


//        System.out.println(list.stream()
//                .filter(el -> el % 2 == 0)
//                .count());


//        list.stream()
//                .distinct()
//                .forEach(System.out::println);

//        System.out.println(list.stream()
//                .filter(el -> el % 2 == 1)
//                .findAny());
//
//        System.out.println(list.stream()
//                        .sorted()
//                        .filter(el -> el > 0)
//                        .findFirst());


//        System.out.println(list.stream()
//                .map(el -> Math.pow(el, 2))
//                .reduce(0.0, (total, el) -> total + el));


//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("Michael", 22, 1500));
//        employees.add(new Employee("Bob", 32, 1800));
//        employees.add(new Employee("Jack", 42, 1000));
//        employees.add(new Employee("David", 19, 1200));
//        employees.add(new Employee("Matew", 51, 1700));
//        employees.add(new Employee("Alice", 25, 1900));
//
//
//
//        employees.stream()
//                .filter(employee -> employee.getAge() < 30)
//                .forEach(employee -> employee.setSalary(employee.getSalary() * 12));
//
//        employees.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
//                .limit(3)
//                .map(employee -> {
//                    employee.setSalary(employee.getSalary() / 12);
//                    return employee;
//                })
//                .forEach(employee -> System.out.println("Name: "+ employee.getName() + ", Salary: " + employee.getSalary()));



//        Vehicle car = new Car("Car1", 200.0);
//        Car car2 = new Car("Car2", 200.0);

//        Employee manager = new Manager("manager1", 23, 1000, 5);
//        Employee programmer1 = new Programmer("programmer1", 32,1200, true);
//        Employee programmer2 = new Programmer("programmer2", 26, 1200, false);
//        Employee trainee1 = new Trainee("trainee1", 21, 200, 29);
//        Employee trainee2 = new Trainee("trainee2", 22,200,35);
//
//        List<Employee> employees = Arrays.asList(manager, programmer1, programmer2, trainee1, trainee2);
//        double res = 0;
//        for (Employee employee : employees) {
//            res += employee.bonus();
//        }
//        System.out.println(res);
//
//        System.out.println(employees.stream().mapToDouble(employee -> employee.bonus()).sum());




//        Zoo zoo = new Zoo();
//        System.out.println(zoo.findAnimal("bird"));
//        zoo.listOfAllAnimals();
//        zoo.addAnimal(new Bird("crow"));
//        zoo.addAnimal(new Mammal("tiger"));
//        zoo.addAnimal(new Mammal("lion"));
//        zoo.addAnimal(new Fish("shark"));
//        zoo.addAnimal(new Fish("seahorse"));
//        zoo.addAnimal(new Bird("flamingo"));
//
//        System.out.println(zoo.findAnimal("tiger"));
//        zoo.listOfAllAnimals();

    }
}

