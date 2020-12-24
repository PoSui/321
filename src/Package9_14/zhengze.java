package Package9_14;

public class zhengze {
    public static void main(String[] args) {
        String s ="sfds55d66s76455dfg32434eertertre";
        s = s.replaceAll("[^0-9]","");
        System.out.println(s);
        String s1 ="sfds55d66s76455dfg32434eertertre";
        StringBuilder s2 = new StringBuilder();
        for (int i = 0;i<s1.length();i++) {
            if(s1.charAt(i)=='0' ||s1.charAt(i)=='1' ||s1.charAt(i)=='2' ||s1.charAt(i)=='3'
                    ||s1.charAt(i)=='4' ||s1.charAt(i)=='5' ||s1.charAt(i)=='6' ||s1.charAt(i)=='7' ||s1.charAt(i)=='8' ||s1.charAt(i)=='9'){
                s2.append(s1.charAt(i));
            }
        }
        System.out.println(s2.toString());

    }

}
