package Package9_10.oneSbTest;

import Package9_14.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class register {
    static int id = 1;
    public static void register(User user){
        String s = "insert into usertable(id,username,password) values ("+id+",'"+user.username+"',"+user.password+")";
        id++;
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("注册成功："+user.username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(s!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
