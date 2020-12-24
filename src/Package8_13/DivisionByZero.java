package Package8_13;

public class DivisionByZero {
    public static int division() throws Exception{
        int a = 0;
        a = 10/0;
        return a;
    }

    public static void main(String[] args)  {
    try {
        division();
    }catch (Exception e){
        e.printStackTrace();
    }

    }
}
