package leetCode;

import javax.swing.tree.TreeNode;

public class Test5 {

    public static boolean isPalindrome(int x) {
        int y=0;
        int huiwen=x;
        //回文数，从后向前取数字，得到的结果和原来的数字一致。
        while(x>0){//1/10=0；
            y=y*10+x%10;//1.y=1 2.y=12
            x=x/10;//1.n=1232 n=123
        }
        if(y==huiwen){
            System.out.println("是回文数");
            return true;
        }else{
            System.out.println("不是回文数");
            return false;
        }

    }

    public static void main(String[] args) {
        Test5.isPalindrome(-123);

    }
}
