package Package8_12;

public class User {
    protected int id;//id号
    public String name; //用户名
    private String password;//密码


    boolean checkName(String name) {
        if("name".equals(this.name)){
            return true;
        }
        return false;
    }

    public User getName(String name) {
//        this.name=name;
        return this;
    }

    public void doSomething() {
        System.out.println("无参做事");
    }

    public void doSomething(String name, String password) {
        System.out.println("两参做事");
    }

    public void doSomething(int id, String name, String password) {
        System.out.println("三参做事");

    }

}