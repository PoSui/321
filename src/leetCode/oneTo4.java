package leetCode;

public class oneTo4 {
    public static int getNumOfNotRepeat(){
        int count = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 5; k++) {
                    if(i!=j && i!=k && j!=k){
                        System.out.println(i+""+j+""+k);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        oneTo4.getNumOfNotRepeat();
    }
}
