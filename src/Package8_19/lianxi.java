package Package8_19;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class lianxi {

    /**
     * @param args
     * 练习题： 将一张图片拷贝到另外一个地方。
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String str1 = "C:\\Users\\破碎\\Desktop\\方舟专精.jpg";
        String str2 = "D:\\app\\test\\方舟专精.jpg";
//        copyFile1(str1, str2);
//        copyFile2(str1, str2);
        copyFile3(str1, str2);

    }
    // 方法一
    public static void copyFile1(String srcPath, String destPath) throws IOException {
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);

        // 读取和写入信息
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关

    }
    // 方法二
    public static void copyFile2(String srcPath, String destPath) throws IOException {

        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);

        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关

    }
    // 方法三
    public static void copyFile3(String srcPath, String destPath) throws IOException {

        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);

        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }

        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关
        System.out.println("复制成功");
        System.out.println("复制路径："+srcPath);
        System.out.println("目标路径："+destPath);
    }

}
