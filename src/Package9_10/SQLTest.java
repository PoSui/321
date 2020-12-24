package Package9_10;


import Package9_14.Utils;

import java.sql.*;

public class SQLTest {

    public static void delete(teacher t){
        String s = "delete from teacher where id ="+t.id;
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("删除成功："+t.name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(c,stmt);
        }
    }
    public static void insertTeacher(teacher t){
        String s = "insert into teacher(id,name,age,salary) values ("+t.id+",'"+t.name+"',"+t.age+","+t.salary+")";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("插入成功："+t.name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(c,stmt);
        }
    }
    public static void insertBatch(teacher t){
        Connection c = Utils.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into teacher(id,name,age,salary) values(?,?,?,?)";
        try {
            ps = c.prepareStatement(sql);
            for(int i = 1;i<=50;i++){
                ps.setInt(1,i);
                ps.setString(2,t.name+i);
                ps.setInt(3,i);
                ps.setInt(4,t.salary+i);
                ps.execute();
            }
            System.out.println("插入完成");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(c,ps);
        }

    }
    public static void updateTeacher(teacher t){
        String s = "update teacher set name='"+t.name+"',age="+t.age+",salary="+t.salary+" where id="+t.id ;
        Connection c = Utils.getConnection();
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            stmt.execute(s);
            System.out.println("修改成功："+t.name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(c,stmt);
        }


    }
    public static void quaryTeacher(teacher t){
        String s = "select * from teacher where id="+t.id;
        Connection c = Utils.getConnection();
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                System.out.println("id="+id+",name="+name+",age="+age+",salary="+salary);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(c,stmt);
        }
    }
    //关
    public static void close(Connection c,Statement s){
        if(c!=null){
            try {
                c.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(s!=null){
            try {
                s.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        teacher t1 = new teacher(1,"tom",20,3000);
        teacher t2 = new teacher(2,"mary",21,4000);
        teacher t3 = new teacher(3,"jack",22,5000);

//       insertTeacher(t1);
//       insertTeacher(t2);
//       insertTeacher(t3);
//       t1.setSalary(9999);
//       updateTeacher(t1);
//       quaryTeacher(t1);
//       delete(t3);
//  insertBatch(t1);
    }
}
