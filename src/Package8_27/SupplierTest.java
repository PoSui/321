package Package8_27;

import java.util.function.Supplier;

@SuppressWarnings("all")
public class SupplierTest {
    public static void main(String[] args) {

        Supplier<Integer> supplier = ()->{

            int[] arr = {2,3,4,52,333,23};
            int max = arr[0];
            for(int a = 0;a<arr.length;a++){
                if(arr[a]>max){
                    max = arr[a];
                }
            }
            System.out.println(max);
            return max;
        };
        supplier.get();
    }
}
