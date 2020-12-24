package Package8_17;

public class TwoThread extends Thread{


    public static void main(String[] args) {
    Object key = 1;

        Thread t1 = new Thread("t1线程"){
          @Override
          public void run(){
              int i = 1;
              synchronized (key) {
                  while (i < 53) {
                      System.out.print(i);
                      if (i % 2 == 0) {
                          try {
                              key.notify();
                              key.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                      i++;
                  }
                  key.notify();
              }
          }
        };

        Thread t2 = new Thread("t2线程"){
            @Override
            public synchronized void run() {
                String[] arr = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
                int i = 0;
                synchronized (key) {
                    while (i < arr.length) {
                        System.out.print(arr[i]);
                        i++;
                        try {
                            key.notify();
                            key.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    key.notify();
                }
            }
        };

        t1.start();
        t2.start();
    }


}
