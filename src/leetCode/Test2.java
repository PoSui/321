package leetCode;
//输入两个数 其中一个数每一步只能选择+1 -1或x2 求一个数到另一个数最短的步数
public class Test2 {
    public static void change(int a,int b){
        int count=0;
        boolean flag =true;
        while(flag){
         for(int i = 0;i<1000000;i++){
             if(a*Math.pow(2,i) >=b){
                if(b-a*(int)Math.pow(2,i-1) < a*(int)Math.pow(2,i)-b){
                    count = b-a*(int)Math.pow(2,i-1);
                    count+=i;
                    flag=false;
                    break;
                }else {
                    count = a*(int)Math.pow(2,i)-b;
                    count+=i;
                    flag=false;
                    break;
                }
             }
         }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Test2.change(2,16);
    }
}
