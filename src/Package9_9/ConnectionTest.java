package Package9_9;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ConnectionTest {
//    private String driverClass = "oracle.jdbc.driver.OracleDriver";
//    private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
//    private String user = "wuhu";
//    private String password = "123456";


    @Test
    public void Test_Connection(){
        Connection c = null;
        Statement s = null;
        Properties pro = new Properties();

        try {
            FileInputStream in = new FileInputStream("D:\\idea Project\\321\\src\\oracle.properties");
            pro.load(in);
            String driverClass = pro.getProperty("driverClass");
            String url = pro.getProperty("url");
            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            //获取驱动
            Class.forName(driverClass);
            //获取连接对象
            c = DriverManager.getConnection(url,user,password);
            //获取stmt对象
            s = c.createStatement();
            String sql = "select * from s_dept";
            ResultSet set = s.executeQuery(sql);
            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                int region_id = set.getInt(3);
                System.out.println("id="+id+",name="+name+",region_id="+region_id);
            }
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        } finally {
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
