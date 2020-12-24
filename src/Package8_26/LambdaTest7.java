package Package8_26;

public class LambdaTest7 {
    public static void main(String[] args) {
        System.out.println(test(213L,3123L,(l1,l2)->l1+l2));
        System.out.println(test(213L,3123L,(l1,l2)->l1*l2));
    }
    static long test(long l1 ,long l2 ,Action7<Long,Long> action){
      return action.run(l1,l2);
    }
}

@FunctionalInterface
interface Action7<T,R>{
    R run(T t, T t2);
}
