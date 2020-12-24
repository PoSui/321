package Package9_9;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionTest2 {
    @Test
    public void Test_Connection(){
        Dom dom = new Dom();
        Connection c = null;
        Statement s = null;
        Properties pro = new Properties();
        Map<String,String> map = dom.domParse();
        try {
            String driverClass = map.get("driverClass");
            String url = map.get("url");
            String user = map.get("user");
            String password = map.get("password");
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
