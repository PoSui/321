package Package9_16;

import Package9_10.Utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void insert(Student student){
        Connection c = Utils.getConnection();
        String s = "insert into t_student values("+student.getId()+",'"+student.getUsername()+"','"+student.getAddress().toString()+"')";
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("插入完成");
            ResultSet rs = stmt.executeQuery("select * from T_STUDENT");
            while(rs.next()){
                long id = rs.getLong(1);
                String username = rs.getString(2);
                String address = rs.getString(3);
                System.out.println(id+","+username+","+address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(c,stmt);
        }

    }
    public static void selectStu() {
        Connection c = Utils.getConnection();
        String s = "select * from t_student";
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            while(rs.next()){
                long id = rs.getLong(1);
                String username = rs.getString(2);
                String address = rs.getString(3);
                Address realaddress = new Address(address.substring(0,2),address.substring(3,5),address.substring(6,8));
                Student student = new Student(id,username,realaddress);
                System.out.println(student.toString());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(c,stmt);
        }
    }
    public static void main(String[] args) {
        Address address = new Address("中国","江苏","昆山");
        Student student = new Student(1L,"zs1",address);
       // insert(student);
        selectStu();
    }


}
