package Package8_18;

//女孩,负责花钱
public class Girl extends Thread{
    private Account account;
    Girl(Account account, String name) {
        this.account = account;
        setName(name);
    }
    public void run() {
//一直不停的花钱
        while (true) {
//随机钱数（看心情）
            int money = (int) (Math.random() * 10000 + 1);
//刷卡消费
            try {
                account.wit(money);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
//休息1秒后，继续花钱
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}