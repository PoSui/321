package Package8_25;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class URLtest {


        public static void main(String[] args) {
            try {
                URL url = new URL("https://www.jd.com");
//打开这个URL的连接，强制为HttpURL的连接对象
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//设置请求方式
                httpConn.setRequestMethod("GET");
//模拟浏览器发送的请求的情况
                httpConn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0");
//获取这个URL连接的输入流，准备读取数据
                InputStream is = httpConn.getInputStream();
//字节流转换为字符流
                Reader in = new InputStreamReader(is);
                char[] cbuf = new char[1024];
                int len = -1;
                while ((len = in.read(cbuf)) != -1) {
                    System.out.print(new String(cbuf, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        }



