package Package8_18;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources_en;

public class Demo2 {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){

            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
                System.out.println("睡3秒");

                try {
                    sleep(3000);
                    System.out.println("t1中的打断标识为："+this.isInterrupted());
                    System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());

                    System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        t1.start();
        System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
        t1.interrupt();
    }
}
