package Package8_27;

import java.util.function.Consumer;

@SuppressWarnings("all")
public class ConsumerTest2 {
    public static void main(String[] args) {
        String[] arr1 = {"卢本伟,男","五五开,女","white,男"};
        Consumer consumer1 = arr ->{
            String[] arr2 = (String[])arr;
            for(int i = 0;i<arr2.length;i++){
                String[] str = arr2[i].trim().split(",");
                System.out.println(str[0]+":"+str[1]);
            }
        };
        _String(arr1,consumer1);
    }
    private static void _String(String[] str, Consumer<String[]> consumer){
        consumer.accept(str);
    }
}
