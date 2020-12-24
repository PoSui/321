package Package8_27;

import java.util.function.Consumer;
@SuppressWarnings("all")
public class ConsumerTest {
    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();
        String str = "sadasdasdasd";

        Consumer<String> consumer1 = (s) -> {
            StringBuffer str1 =new StringBuffer(s);
            System.out.println(str1.reverse());
        };
        reverseString(str,consumer1);
    }
    private static void reverseString(String str,Consumer<String> consumer){
        consumer.accept(str);
    }
}
