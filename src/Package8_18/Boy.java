package Package8_18;

//男孩,负责挣钱
public class Boy extends Thread {
    private Account account;

    Boy(Account account, String name) {
        this.account = account;
        setName(name);
    }

    public void run() {
//一直不停的挣钱
        while (true) {
//随机钱数
            int money = (int) (Math.random() * 10000 + 1);
//存进账户
            account.pos(money);
            try {
//休息1秒后，继续挣钱
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}