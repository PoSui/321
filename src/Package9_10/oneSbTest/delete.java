package Package9_10.oneSbTest;

import Package9_14.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class delete {
    public static void deleteUser(String str){
        String s = "delete from usertable where username ='"+str+"'";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("删除成功："+str);
        } catch (SQLException throwables) {
            System.out.println("删除失败,用户不存在");
        }finally {
            Utils.close(c,stmt);
        }
    }
}
