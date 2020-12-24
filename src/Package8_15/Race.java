package Package8_15;

public class Race {


    public static void main(String[] args)  {

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        RabbitAndTurtle rabbit = new RabbitAndTurtle();
        RabbitAndTurtle turtle = new RabbitAndTurtle();
        rabbit.start();
        turtle.start();
    }
}
