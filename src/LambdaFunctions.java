import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LambdaFunctions{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);

        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(10);
        numbers1.add(9);
        numbers1.add(8);
        numbers1.add(3);
        Consumer<Integer> method = k -> System.out.print(k);
        numbers1.forEach(method);
        System.out.println("\n");

        List<String> list = Arrays.asList("shubham","ravi","sudame","raj","amol");
        List<String> listfinal = list.stream().filter(n -> n.startsWith("s")).collect(Collectors.toList());
        System.out.println(listfinal);
        System.out.println("\n");

        list.stream().filter(n -> n.startsWith("r")).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        list.stream().map(String::toUpperCase).forEach(n -> System.out.print(n+ " "));

        List<Integer> sortList = Arrays.asList(4,5,2,7,2);

        sortList.stream().sorted().forEach(n -> System.out.print(n+ " "));

        sortList.stream().sorted((a,b) -> b.compareTo(a)).forEach(n -> System.out.println(n + " "));

    }
}
