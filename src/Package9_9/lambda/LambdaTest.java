package Package9_9.lambda;

import org.junit.Test;

public class LambdaTest {
    @Test
    public void test(){
        System.out.println( operation(100,x->x*x));
    }
    public Integer operation(Integer num, myfun myfun){
        return myfun.getValue(num);
    }
}
