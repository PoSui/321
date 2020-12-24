package Package9_10.oneSbTest;

import Package9_14.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void update(User user,String str){
        String s = "update usertable set username= '"+user.username+"', password = "+user.password+" where username = '"+str+"'";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("修改成功："+user.username+","+user.password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(c,stmt);
        }


    }
}
