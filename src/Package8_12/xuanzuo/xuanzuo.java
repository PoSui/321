package Package8_12.xuanzuo;

import java.util.HashMap;
import java.util.Map;

public class xuanzuo {
    public static void main(String[] args) throws Exception {
        ObjectPool2 pool= new ObjectPool2();
        pool.initPool();
        System.out.println(pool.getObject("student"));
        System.out.println(pool.getObject("teacher"));
    }
}
