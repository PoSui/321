package Package8_13;

import java.util.ArrayList;
import java.util.List;

public class Return3 {
    public static void main(String[] args) {
        System.out.println(testReturn2());
    }
    private static String testReturn2() {
        String a ="hello";
        try {
            a+="!";
            System.out.println("try:" + a);
            return a;
        } finally {
            a+="world";
            System.out.println("finally:" + a);
        }
    }
    }

