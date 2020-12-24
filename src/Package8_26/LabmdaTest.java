package Package8_26;

public class LabmdaTest {
    public static void main(String[] args) {
        Action<Number, Number> a = (str) -> {
            return str.length();
        };
        Action<Number, Number> a2 = (str) -> str.length();
        System.out.println(a.test("hello"));
        System.out.println(a2.test("hello"));
    }
}
interface Action<L extends Number, L1 extends Number> {
    public int test(String str);
}

