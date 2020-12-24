package Package9_10;
//3.自定义一个分页类。
//        总页码
//        总页数
//        当前页
//        每页显示条数
//        查询得数据
//        ..
//        将s_emp分页查询结果，每次显示4条数据。


import Package9_14.Utils;

import java.sql.*;
import java.util.Scanner;

public class paging {

   static int Total_page_number;
   static int ColCount = 0;
   static int Current_page;
   static final int Number_of_items_per_page = 4;

    public static void base(){
        System.out.println("当前页:"+Current_page);
    }
    public static void ColCount(){
        System.out.println("总页码:"+Total_page_number);
        System.out.println("总列数:"+ColCount);
    }
    public static void quaryEmp(){
        String s = "select * from s_emp";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        int count=0;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            while(rs.next()){
                int id = rs.getInt("id");
                String last_name = rs.getString("last_name");
                String first_name = rs.getString("first_name");
                String userid = rs.getString("userid");
                java.util.Date date = rs.getDate("start_date");
                String comments = rs.getString("comments");
                int manager_id = rs.getInt("manager_id");
                String title = rs.getString("title");
                int dept_id = rs.getInt("dept_id");
                int salary = rs.getInt("salary");
                int commission_pct = rs.getInt("commission_pct");
                System.out.println("id="+id+",last_name="+last_name+",first_name="+first_name+
                        ",userid="+userid+",start_date="+date+",comments="+comments+
                        ",manager_id="+manager_id+",title="+title+",dept_id="+dept_id
                        +",salary="+salary+",commission_pct="+commission_pct);
                ColCount++;
                count++;
                if(count % 4 ==0){
                    Current_page++;
                    base();
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入D继续");
                String str= scanner.next();
                if(str == "D"){
                    break;
                }
                }

            }
            Total_page_number = (ColCount/Number_of_items_per_page)+1;
            Current_page+=1;
            base();
            ColCount();

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
        paging.quaryEmp();
    }
}
