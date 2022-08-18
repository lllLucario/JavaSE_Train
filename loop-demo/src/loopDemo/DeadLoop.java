package loopDemo;

import java.util.Scanner;

public class DeadLoop {
    public static void main(String[] args) {
        //新建的输入对象要写在循环外面，不占用内存
        Scanner sc = new Scanner(System.in);
        int rightNum = 11;
        while(true){
            System.out.println("起您输入数字");
            int guessData = sc.nextInt();
            if (guessData == rightNum){
                System.out.println("您猜对了");
                break;
            }else {
                System.out.println("您猜错了,请重新输入");
                System.out.println("-----------------");
            }
        }
    }
}
