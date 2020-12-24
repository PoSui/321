package Package8_28;


public class roit {
    public static void main(String[] args) {
        int HP1 = 100;
        int HP2 = 100;
        String name = "刘可天";
        String name2 = "斗林鹏";
        int attack = 1;
        int defned = 0;
        while(HP1>0 && HP2>0){
            System.out.println(name+"打了"+name2+"一拳");
            HP1-=(attack+defned);
            attack+=(Math.random()*10)+1;
            defned+=(Math.random()*10)+1;
            HP2-=defned*0.4;
            System.out.println(name+"HP:"+HP2);
            System.out.println(name2+"HP:"+HP1);
            System.out.println("攻击力"+attack);
            System.out.println("防御力"+defned);
        }
        if(HP1<=0){
            System.out.println(name2+"死了");
        }
        if(HP2<=0){
            System.out.println(name+"死了");
        }
    }
}
