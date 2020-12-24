package Package9_10.oneSbTest;

import Package9_14.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login {
    public static boolean login(User user){
        String s = "select * from usertable ";
        Connection c = Utils.getConnection();
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(s);

            if(rs.next()){
                String username = rs.getString("username");
                int password = rs.getInt("password");
                if(username.equals(user.username) && password == user.password){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Utils.close(c,stmt);
        }
        System.out.println("无此用户");
        return false;
    }
}
