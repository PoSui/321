package Package8_26;

public class LambdaTest6 {
    public static void main(String[] args) {
        String str1 = "adasdqwdsa";
        test(str1 , (str) ->{
            str = str.toUpperCase();
            System.out.println(str);
            str = str.substring(2,4);
            System.out.println(str);
            return str;
        });
    }
    static void test(String s, Action6 action6){
        action6.getValue(s);
    }
}
@FunctionalInterface
interface Action6{
    public String getValue(String s);
}
