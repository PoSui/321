package circle;

public class Circle {
    private double r;
    double eps = 1;
    Circle(double r){
        this.r = r;
    }
    public void printCricle() {
        double R = 2*r;
        String s =null;
        for(int i = 0;i <= R;i+=3) {
            double y;
            if(i <= r)	y = r-i;
            else y = i-r;
            double len =  Math.round(Math.sqrt(r*r - y*y));
            for(int j = 0;j < r-len;j++)	System.out.print(" ");
            System.out.print("*");
            for(int j = 0;j < 2*len;j++)	System.out.print(" ");
            System.out.println("*");
        }
    }

    public static void main(String[] args) {
//        Circle circle = new Circle(30);
//        circle.printCricle();


    }
            }
