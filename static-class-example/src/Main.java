import java.util.*;

public class Main {

        public class StaticClassExample {

         public static class MathUtility {
              public static double calculateSquare(double num) {
                    return num * num;
                }
            }

            public static void main(String[] args) {
                double result = MathUtility.calculateSquare(5);
                System.out.println("Square of 5 is: " + result);
            }
        }


    public class AnonClassExample {
        interface Greeting {
            void greet();
        }

        public static void main(String[] args) {
            Greeting englishGreeting = new Greeting() {
                @Override
                public void greet() {
                    System.out.println("Hello");
                }
            };

            Greeting frenchGreeting = new Greeting() {
                @Override
                public void greet() {
                    System.out.println("Bonjour");
                }
            };

            englishGreeting.greet();  // Выводит "Hello"
            frenchGreeting.greet();   // Выводит "Bonjour"
        }
    }

    public class Outer {
        void someMethod() {
            class Local {
                // ...
            }
        }
    }




    class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person otherPerson) {
            return Integer.compare(this.age, otherPerson.age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public class ComparableExample {
        public void main(String[] args) {
            List<Person> people = new ArrayList<>();

            people.add(new Person("Alice", 30));
            people.add(new Person("Bob", 25));
            people.add(new Person("Charlie", 35);

            // Сортировка списка людей с использованием Comparable (по возрасту)
            Collections.sort(people);

            for (Person p : people) {
                System.out.println(p);
            }
        }
    }


// Пример класса Employee
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

// Реализация Comparator в классе Employee по зарплате
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Double.compare(emp1.getSalary(), emp2.getSalary());
    }
}

public class ComparatorImplementationExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 45000));

        // Использование реализованного Comparator для сортировки
        employees.sort(new SalaryComparator());

        for (Employee e : employees) {
            System.out.println(e);
        }
    }


    public class Box<T> {

        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    // Использование обобщенного класса
    Box<Integer> integerBox = new Box<>();

    integerBox.setValue(10);
    int num = integerBox.getValue();




//    ArrayList
//
//    LinkedList
//
//    HashSet
//
//    TreeSet
//
//    HashMap
//
//    TreeMap


    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Пример использования потоков для фильтрации и вывода результатов

    names.stream()
        .filter(name -> name.startsWith("A"))
            .map(String::toUpperCase)
                .forEach(System.out::println);


//   (a, b) -> {return a + b;}
//    a -> a * a

    //distinct


        }
}