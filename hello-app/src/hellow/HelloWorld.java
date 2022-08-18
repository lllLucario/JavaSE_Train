package hellow;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        int age = 23;
        double db = age;
        System.out.println(db);
        System.out.println("------------");

        int i = 10;
        int j = i ++;
        System.out.println(i);
        System.out.println(j);

        System.out.println("上面是后++，先用值，后运算");

        int k = 10;
        int s = ++ k;
        System.out.println(k);
        System.out.println(s);
        System.out.println("下面是前++，先运算，后用值");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的体重:");
        int weight = sc.nextInt();
        System.out.println("您的体重是：" + weight);

        System.out.println("您有什么想说的话吗：");
        String sentence = sc.next();
        System.out.println("收到！");








    }
}
