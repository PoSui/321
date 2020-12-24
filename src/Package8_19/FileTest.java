package Package8_19;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    private static List<File> files = new ArrayList<File>();
    public static List<File> getDirAllFiles(File directory) {
        File[] files2 = directory.listFiles();
        for (File file : files2) {
            if (file.isFile()) {
                files.add(file);
            }else if (file.isDirectory()) {
                getDirAllFiles(file);
            }
        }
        return files;
    }

    public void exit(String path){
        File file = new File(path);
        System.out.println("要查找的文件为"+path);
        if(file.exists()){
            System.out.println("文件存在");
        }else {
            System.out.println("文件不存在");
        }
    }
    public static void main(String[] args) {
//        String pathname = "Hello.java";
//        File file = new File(pathname);
//        System.out.println("----------");
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getPath());
//        System.out.println("-------------");
        //String fname = "D:/app/test/a.txt";
        String fdir = "D:/app/test";

        File directory = new File(fdir);
        //测试一
        List<File> files = getDirAllFiles(directory);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("文件的个数："+files.size());

        FileTest fileTest = new FileTest();
        fileTest.exit("D:\\app\\test\\b.txt");
    }


}

