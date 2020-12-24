package Package8_28;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("????");
        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println( optional.isPresent()+","+optional2.isPresent());
        System.out.println( optional.get()+",");
        System.out.println("=========");
        optional.ifPresent(str -> System.out.println(str));
        optional.ifPresent(System.out::println);
        optional.ifPresent(String::length);

        Optional<Integer> map1 = optional.map(str->1);
        System.out.println(map1.orElse(0));
        Optional<Double> map2 = optional2.map(str->1.2);
        System.out.println(map2.orElse(0D));
    }
}
