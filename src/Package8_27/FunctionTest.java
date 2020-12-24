package Package8_27;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        String s = "123";
        Function<String,Integer> fun = s1 -> {
            Integer integer = Integer.parseInt(s1)+10;
            System.out.println(integer);
            String s2 = integer.toString();
            System.out.println(s2.getClass());
            return 1;
        };
        fun.apply(s);
    }

}
