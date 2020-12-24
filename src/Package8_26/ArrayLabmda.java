package Package8_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@SuppressWarnings("all")
public class ArrayLabmda {

    public static void main(String[] args) {

        Action1 action1 = () ->{
            List list1 = new ArrayList();
            List list = new ArrayList();
            for(int i=0;i<20;i++){
                int a =(int)(Math.random()*100)+1;
                list.add(a);
                if(a%2==0){
                    list1.add(a);
                }
            }
            System.out.println("大数组：");
            System.out.println(list);
            System.out.println("小数组：");
            System.out.println(list1);

            return list1;
        };
        action1.run();
    }

}
interface Action1{
    public List run();
}