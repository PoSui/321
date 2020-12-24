package Package9_10.oneSbTest;

import java.util.List;
import java.util.Scanner;

public class PSVM {
    public static void main(String[] args) {
        boolean flag = true;
        boolean flag2 = true;
        String s= "";
        System.out.println("输入login登陆，如果没有账户，输入register注册");
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();

        while(flag){

            switch (s){
                case "login":
                    System.out.println("请输入用户名(登录)：(输入quit退出程序，输入back去注册)");
                    String username = scanner.next();
                    if(username.equals("quit")){
                        System.exit(0);
                    }
                    if(username.equals("back")){
                        s = "register";
                        break ;
                    }
                    System.out.println("请输入密码：");
                    try {
                        int password = scanner.nextInt();
                        if(login.login(new User(username,password))){
                            System.out.println("登录成功");
                        }else {
                            System.out.println("登陆失败，自动跳转到注册");
                            s = "register";
                            break ;
                        }
                    }catch (Exception e){
                        System.out.println("密码只允许是数字");
                        break;
                    }

                    flag = false;
                    break;
                case "register":
                    System.out.println("请输入用户名(注册)：(输入quit退出程序，输入back去登录)");
                    String username1 = scanner.next();
                    if(username1.equals("quit")){
                        System.exit(0);
                    }
                    if(username1.equals("back")){
                        s = "login";
                        break ;
                    }
                    System.out.println("请输入密码：");
                    try {
                        int password1 = scanner.nextInt();
                        register.register(new User(username1,password1));
                    }catch (Exception e){
                        System.out.println("密码只允许是数字");
                    }

                    flag = false;
                    break;
                default:
                    System.out.println("输入不正确,自动跳转到注册");
                    s = "register";
                    break;
            }
        }
        while(flag2){
            System.out.println("输入编号来进入功能");
            System.out.println("1.查询所有用户信息");
            System.out.println("2.修改用户信息");
            System.out.println("3.删除用户信息");
            System.out.println("4.查询用户信息，仅查询username");
            System.out.println("5.退出程序");
            Scanner scanner2 = new Scanner(System.in);
            String s2 = scanner2.next();
            switch (s2){
                case "1":
                    selectAll.selectAll();
                    break;
                case "2":
                    System.out.println("输入要修改的用户的名称：");
                    Scanner s3 = new Scanner(System.in);
                    String str1 = s3.next();
                    List<String> list = selectAll.selectName();
                    for(String str : list){
                        if(!str1.equals(str)){
                            System.out.println("用户不存在！");
                            break;
                        }else {
                            System.out.println("用户"+str1+"存在，请继续输入。");
                        }
                    }
                    System.out.println("输入修改后的用户的名称：");
                    String str2 = s3.next();
                    System.out.println("输入需修改后的用户密码：");
                    int str3 = s3.nextInt();
                    Update.update(new User(str2,str3),str1);
                    break ;
                case "3":
                    System.out.println("输入要删除的用户的名称：");
                    Scanner s4 = new Scanner(System.in);
                    String str4 = s4.next();
                    delete.deleteUser(str4);
                    break;
                case "4":
                    System.out.println(selectAll.selectName().toString());
                    break;
                case "5":
                    System.out.println("确认退出？(y/n)");
                    Scanner s5 = new Scanner(System.in);
                    if("y".equals(s5.next()) ){
                        flag2 = false;
                        break;
                    }else {
                        break;
                    }

                default:
                    System.out.println("重来");

            }

        }
    }
}
