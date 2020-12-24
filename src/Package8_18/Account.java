package Package8_18;

class Account {
    //账号余额
    private int balance;
    Account(int balnace) {
        this.balance = balnace;
    }
    //存钱
    synchronized void pos(int money){
        String name = Thread.currentThread().getName();
        balance+=money;
        System.out.println(name+"给账户存钱"+money+"元，现在账户余额为"+balance);
        this.notifyAll();
    }
    //消费
    synchronized void wit(int money) throws InterruptedException {
        String name = Thread.currentThread().getName();
        if(balance-money>=0) {
            balance -= money;
            System.out.println(name+"消费"+money+"元，现在账户余额为"+balance);
        }else {
            while(balance<money){
                this.wait();
            }
        }
    }
}
