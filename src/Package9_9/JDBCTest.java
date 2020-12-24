package Package9_9;

import org.junit.Test;

import java.sql.Driver;

public class JDBCTest {
    @Test
    public void testDriver(){
        String s = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_driver2() {
        //创建出驱动对象
        Driver driver =
                new oracle.jdbc.driver.OracleDriver();
    }

}
