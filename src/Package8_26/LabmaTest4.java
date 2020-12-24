package Package8_26;



public class LabmaTest4{
    public static void main(String[] args) {


    Action4 action4 = () ->{
        Runnable runnable = () -> System.out.println("hello");
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(thread.getName()+"启动");
    };
    action4.run();
    }
}

interface Action4 extends Runnable{
    @Override
    void run();
}
