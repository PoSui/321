package Package9_14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class register {

    static void register(){
        String sql = "select name from member";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("注册");
            System.out.println("输入用户名（2-4位中文）");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            if(!name.matches("^[\\u4e00-\\u9fa5]{2,4}$")) {
                throw new PSException("不符合用户名要求，重新输入！");
            }
                    //@"^[\u4E00-\u9FA5]{2,4}$";
            while(rs.next()){
                String rsname = rs.getString("name");
                if (rsname.equals(name)) {
                    throw new PSException("用户名已存在");
                }
                break;
            }
            System.out.println("请输入密码：（密码是6-18位数字）");
            String psword = scanner.next();
            if(!psword.matches("^\\d{6,18}$")){
                throw new PSException("不符合密码要求，重新输入！");
            }
            System.out.println("确认密码：");
            String repsword = scanner.next();
            if(!repsword.equals(psword)){
                throw new PSException("两次密码不匹配，重新输入！");
            }
            sql = "insert into member values('"+name+"','"+psword+"')";
            stmt.execute(sql);
            System.out.println("注册成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(c,stmt);
        }



    }


    public static void main(String[] args) {
            register();
    }
}
