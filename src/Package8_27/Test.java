package Package8_27;

import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        Student stu = new Student("tom");
//操作1，给stu对象的name属性值加前缀
        Consumer<Student> consumer1 = (s) -> s.name = "briup_"+s.name;
//操作2，给stu对象的name属性值加后缀
        Consumer<Student> consumer2 = (s) -> s.name =
                s.name+"_"+System.currentTimeMillis();
//操作3，给stu对象的name属性值，先加前缀，再加后缀
        Consumer<Student> consumer3 = consumer1.andThen(consumer2);
//如果传入consumer1，表示只加前缀
//如果传入consumer2，表示只加后缀
//如果传入consumer3，表示先加前缀，再加后缀
        t.operString(stu,consumer3);
        System.out.println(stu.name);
    }
    public void operString(Student stu, Consumer<Student> consumer){
        consumer.accept(stu);
    }
}
class Student{
    String name;
    public Student(String name) {
        this.name = name;
    }
}
