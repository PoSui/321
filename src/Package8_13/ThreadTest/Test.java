package Package8_13.ThreadTest;

public class Test{
    static int tick = 100;
    static Object key=1;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                    while (tick > 0) {

                        synchronized(key){
                            if (tick==0){
                                System.out.println(Thread.currentThread().getName()+"知道票卖完了");
                                return;
                            }

                            System.out.println("这是" + Thread.currentThread().getName() + "卖的第" + (101-tick) + "张票");
                            if(101-tick==100){
                                System.out.println(Thread.currentThread().getName()+"知道票卖完了");
                            }
                            tick--;

                        }
                    }
                }
        };

        Thread t1 =new Thread(runnable,"窗口1");
        t1.start();
        Thread t2 =new Thread(runnable,"窗口2");
        t2.start();
        Thread t3 =new Thread(runnable,"窗口3");
        t3.start();
        Thread t4 =new Thread(runnable,"窗口4");
        t4.start();



    }

}
