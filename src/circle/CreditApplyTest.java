package circle;

import java.io.*;

public class CreditApplyTest {
    public static void main(String[] args) {
        CreditApply a = new CreditApply(1001,"张三","抵押",100000.5);
        CreditApply b = new CreditApply(1002,"李四","质押",50000.0);
        CreditApply c = new CreditApply(1003,"王五","质押",30000.0);
        CreditApply d = new CreditApply(1004,"赵六","抵押",60000.51);
        String s1=a.toString();
        String s2=b.toString();
        String s3=c.toString();
        String s4=d.toString();
        File f =new File("C:\\Users\\破碎\\Desktop\\credit.txt");

        byte data[] = {88,89};
//创建基于文件的输出蔬
        FileWriter fw = null;
        try {
            fw = new FileWriter(f, true);
            fw.write(s1);
            fw.write(s2);
            fw.write(s3);
            fw.write(s4);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
