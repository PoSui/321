package leetCode;

public class Test6 {

    public static int reverse(int x) {
        Integer i = 0;
        if(x<0) {
            x = Math.abs(x);
            StringBuffer s = new StringBuffer(String.valueOf(x));
            s.reverse();
            try {
            i = Integer.parseInt(s.toString());
            }catch (Exception e){
                return 0;
            }
//            System.out.println(-i);
            return -i;
        }
        StringBuffer s = new StringBuffer(String.valueOf(x));
        s.reverse();
        try {
            i = Integer.parseInt(s.toString());
        }catch (Exception e){
            return 0;
        }
//       System.out.println(i);
        return i;
    }
    public static void main(String[] args) {
        Test6.reverse(  -2147483648);

    }
}
