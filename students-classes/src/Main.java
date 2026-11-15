import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
    public static void main(String[] args) {

        Students student1 = new Students("Maria", 12, 78);
        Students student2 = new Students("Janina", 12, 90);
        Students student3 = new Students("Bartek", 13, 68);
        Students student4 = new Students("Wiktor", 12, 45);
        Students student5 = new Students("Kasia", 12, 66);
        Students student6 = new Students("Janek", 13, 66);


        List<Students> allStudents = Arrays.asList(student1, student2, student3, student4, student5, student6);

        int amount = allStudents.stream()
                                    .filter(mark -> mark > 50)
                                        .map(name -> 1)
                                            .reduce(0, (a,b) -> a + b)
                                                .collect(Collectors.toList());

        System.out.println(amount);

        int amount = allStudents.stream()
                                   .filter(mark -> mark > 50)
                                        .sorted.(group)
                                            .sorted(mark)
                                                .collect(Collectors.toList());

        System.out.println(amount);


        Map<String, List<Students>> groupedStudents = new HashMap<String, List<Students>>();









    }
}