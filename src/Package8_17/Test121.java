package Package8_17;

public class Test121 {

    private int [] arr = new int[20];
    private int current;

    public synchronized void add(int num){
        String name = Thread.currentThread().getName();
        arr[current] = num;
        System.out.println(name+"线程本次写入的值为"+num+"，写入后取出的值为"+arr[current]);
        current++;
    }


}
class Test{
    public static void main(String[] args) {
        Test121 t = new Test121();
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    t.add(i);
//计算机运行10次运行太快了，让它执行慢一些，好观察效果
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread("\tt2"){
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    t.add(i);

//计算机运行10次运行太快了，让它执行慢一些，好观察效果
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
            t1.start();
            t2.start();
    }
}

