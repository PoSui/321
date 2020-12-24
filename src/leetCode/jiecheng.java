package leetCode;

public class jiecheng {
        public static void main(String[] args) {

            long n=1,m,s,k=0;
            while(n<=20) {
                for(s=1,m=1;m<n;m++)
                    s=s*m;//计算n!，结果存于s中
                k=k+s;//计算前n项阶乘之和，结果存于k中
                if(n==20) {
                    System.out.println(n + "!=" + s + "  k=" + k);
                }
                n++;
            }
        }
    }

