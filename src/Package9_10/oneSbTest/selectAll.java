package Package9_10.oneSbTest;

import Package9_14.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectAll {
    public static void selectAll() {
        String s = "select * from usertable";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                int password = rs.getInt("password");
                System.out.println("id=" + id + ",name=" + name + ",password=" + password );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Utils.close(c,stmt);
        }
    }

    public static List<String> selectName() {
        List<String> list = new ArrayList<>();
        String s = "select * from usertable";
        Connection c = Utils.getConnection();
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            if (rs.next()) {
                String name = rs.getString("username");
                list.add(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Utils.close(c,stmt);
        }
        return list;
    }
}


