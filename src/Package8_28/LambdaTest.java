package Package8_28;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class LambdaTest {
    public static void main(String[] args) {
        Student student = new Student();
        Action action = Student::test;
        action.run(student);
    }

}
interface Action{
    void run(Student student);
}
class Student{
     static void test(Student student){
        System.out.println("123");
    }

     void test1(Student student, String s){
        System.out.println("123");
    }
}
