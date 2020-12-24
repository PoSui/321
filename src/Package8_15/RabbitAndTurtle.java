package Package8_15;

public class RabbitAndTurtle extends Thread{
    private static int roundRabbit = 100;
    private static int roundTurtle = 100;
    private boolean flag = false;
    private final Object key = 1 ;
    @Override
    public void run() {
        while (roundTurtle > 0 || roundRabbit > 0) {
            synchronized (key) {
                if (roundTurtle == 0 || roundRabbit == 0) {
                    flag = true;
                }
                if (flag && roundRabbit == 0) {
                    System.out.println("比赛结束,兔子获胜");
                    return;
                } else if (flag && roundTurtle == 0) {
                    System.out.println("比赛结束,乌龟获胜");
                    return;
                }
                if (Math.random() <= 0.333333333333333333333333) {
                    roundRabbit--;
                    roundRabbit--;
                    System.out.println("兔子跑了2米,剩余" + roundRabbit + "米");
                } else {
                    roundTurtle--;
                    System.out.println("乌龟跑了1米,剩余" + roundTurtle + "米");
                }
              //  this.isAlive();
            }
        }
    }
}
