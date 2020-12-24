package Package8_27;

import java.util.*;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        PredicateTest predicateTest = new PredicateTest();
        String[] arr = {"卢本伟,男", "五五开,女", "white,男"};
        filter(arr,str->{
            String[] str1 = str.trim().split(",");
            return str1[0].length()==3 && "男".equals(str1[1]);
        }).forEach(System.out::println);
    }
    private static List<String> filter(String[] arr, Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for(String str : arr){
            if(predicate.test(str)){
                list.add(str);
            }
        }
        return list;
    }
}

