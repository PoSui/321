package Package8_20;

import java.io.File;

public class digui {

    public static void main(String[] args) {
        File file =new File("D:\\app\\test");
        digui.getAllFile(file);
    }
    public static void getAllFile(File dir) {
        File[] files = dir.listFiles();//返回文件列表
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFile(f);
            } else {
                System.out.println(f);
            }
        }
    }
}
//f是一个文件夹，则继续遍历这个文件夹
//我们发现getAllFile方法就是传递文件夹，遍历文件夹的方法
//所以直接调用getAllFile方法即可：递归（自己调用自己）