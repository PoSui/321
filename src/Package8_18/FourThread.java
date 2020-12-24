package Package8_18;

public class FourThread implements Runnable{
    private static int j = 0;
    private final Object key = 1 ;
    @Override
    public void run() {
        while(true) {
            synchronized (key) {
                if(("t1").equals(Thread.currentThread().getName()) ||("t2").equals(Thread.currentThread().getName())) {
                    j += 1;
                    System.out.print(Thread.currentThread().getName()+"操作：");
                    System.out.println("j+1,j的值为"+j);
                }
                if(("t3").equals(Thread.currentThread().getName()) ||("t4").equals(Thread.currentThread().getName())) {
                    j -= 1;
                    System.out.print(Thread.currentThread().getName()+"操作：");
                    System.out.println("j-1,j的值为"+j);
                }

            }
        }
    }
}
class TestFour{
    public static void main(String[] args) {
        FourThread fourThread = new FourThread();
        Thread t1 = new Thread(fourThread, "t1");
        Thread t2 = new Thread(fourThread, "t2");
        Thread t3 = new Thread(fourThread, "t3");
        Thread t4 = new Thread(fourThread, "t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
