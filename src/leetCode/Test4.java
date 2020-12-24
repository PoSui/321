package leetCode;

public class Test4 {

    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
    public static void main(String[] args) {
        Test4.convertToBase7(-8);
    }
}
