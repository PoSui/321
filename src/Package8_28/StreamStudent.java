package Package8_28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudent {
    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "jack", "Max", "Никита Сергеевич Хрущёв", "那位大人");
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "tom", "mary", "那位教员", "斯大林", "张长弓");
        System.err.println("第一题：");
        list1.stream().filter(str -> str.length() == 3).collect(Collectors.toList()).forEach(System.out::println);
        System.err.println("第二题：");
        list1.stream().limit(3).forEach(System.out::println);
        System.err.println("第三题：");
        list2.stream().filter(str -> str.contains("张")).collect(Collectors.toList()).forEach(System.out::println);
        System.err.println("第四题：");
        list2.stream().filter(str -> str.contains("张")).skip(2).collect(Collectors.toList()).forEach(System.out::println);
        System.err.println("第五题：");
        Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList()).forEach(System.out::println);
        Thread.sleep(100);
        System.err.println("第六题和第七题：");
        Stream.concat(list1.stream(), list2.stream()).map(Person::new).collect(Collectors.toList()).forEach(System.out::println);

    }
}
