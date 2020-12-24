package Package9_14;

import java.util.Timer;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * @author 破碎
 */
@SuppressWarnings("all")
public class Timers {

    public static void main(String[] args) {
        timer();
    }

    public static void timer(){

        Timer t = new Timer();

        t.schedule(new TimerTask(){
            @Override
            public void run(){
                  Calendar cal = Calendar.getInstance();
                  int month = cal.get(Calendar.MONTH)+1;
                  System.out.println("当前月份："+month+"月");
            }
        },0,1000*60*2);


    }
}
