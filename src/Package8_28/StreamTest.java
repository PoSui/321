package Package8_28;

/**
 * 链式编程？
 *
 *
 *
 */
public class StreamTest {
    public static void main(String[] args) {
            Student1 student1 = new Student1();
            System.out.println(student1.setId(1L).setAge(20).setName("tom").toString());
    }
}
class Student1{
    String name;
    int age;
    long id;

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public Student1 setName(String name) {
        this.name = name;
        return this;
    }

    public Student1 setAge(int age) {
        this.age = age;
        return this;
    }

    public Student1 setId(long id) {
        this.id = id;
        return this;
    }
}
