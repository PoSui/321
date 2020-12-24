package refelectPackage;

public class Student implements Action,Mark{
    private String name;
    int age;
    public static int num;
    public Student(){}
    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String sayHello(String name){
        return "hello! "+name;
    }
    @Override
    public void run() {
    }
    @Override
    public void star() {
    }
}
interface Action{
    void run();
}
interface Mark{
    void star();
}