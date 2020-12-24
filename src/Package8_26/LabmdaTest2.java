package Package8_26;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class LabmdaTest2 {
    public static void main(String[] args) {
        Action2 action = () -> {
            List list = new ArrayList();
            list.add("tom");
            list.add("tom");
            list.add("MARY");
            list.add("MARY");
            list.add("jack");
            list.add("jack");
            list.add("jack");
            list.add("sam");
            list.add("sam");
            list.add("tom");
            List list1 = new ArrayList();
            for(int i=0 ;i<list.size();i++) {
                if(!list1.contains(list.get(i))){
                    list1.add(list.get(i));
                }
            }
            System.out.println(list);
            System.out.println(list1);
        };
        action.run();
    }


}
interface Action2{
    void run();

}