package Package8_20;

import java.io.*;


public class StrCount {

    public void count(String path,String str) throws IOException {

        Reader in = null;
        Writer out = null;

        File file = new File(path);
        // System.out.println(file.exists());
        try {
            in = new FileReader(file);
            //out = new CharArrayWriter();
            char[] buf = new char[1024];
            in.read(buf, 0, buf.length);
            //System.out.println(Arrays.toString(buf));
            int i = 0;
            String a = "";
            int count = 0 ;
            int count1 = 0 ;
            while(i<buf.length) {
                if(buf[i] !=(char)32)
                    a+=buf[i];
                i++;
                if(a.contains(str)){
                    //  System.out.println(a.indexOf(str));
                    a = a.substring(a.indexOf(str)+str.length());
                    count++;
                }
                if(a.contains("a")){
                    //  System.out.println(a.indexOf(str));
                    a = a.substring(a.indexOf("a")+"a".length());
                    count1++;
                }
            }
            System.out.println();
            System.out.println(str+"匹配的数量为"+count);
            System.out.println("a匹配的数量为"+count1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }


    }

    public static void main(String[] args) {
        StrCount SC = new StrCount();
        try {
            SC.count("D:\\app\\test\\calcCharNum.txt","A");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
