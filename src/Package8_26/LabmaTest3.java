package Package8_26;

import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("all")
public class LabmaTest3 {
    public static void main(String[] args) {


        Action3 action3 = (map) -> {
            map.put(1,"1");
            map.put(2,"2");
            map.put(3,"3");
            map.put(4,"4");
            map.put(5,"5");
            for( Object o : map.entrySet()){
                System.out.println(o);
            }
        };
        Map map = new HashMap();
        action3.run(map);
    }

}
interface Action3{
    void run(Map map);
}
