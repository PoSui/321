package Package8_26;

public class LabmdaTest5 {
    public static void main(String[] args) {
       String str1 = "3123123";
        test(str1,(str) -> {
            //System.out.println(Integer.parseInt(str));
            for(int i = 0;i < str.length();i++) {
                System.out.println(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        });
    }
    static void test(String str,Action5 action){
       action.run(str);
    }
}
@FunctionalInterface
interface Action5{
    void run(String str);
}
