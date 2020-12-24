package Package8_28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);

        list = list.stream()
                .filter(e -> e%2==0)
                .sorted((e1,e2) -> -e1-e2)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
