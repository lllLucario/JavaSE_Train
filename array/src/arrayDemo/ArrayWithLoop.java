package arrayDemo;

import java.util.Random;
import java.util.Scanner;

public class ArrayWithLoop {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("您想生成多少个数字？");
        int num = sc1.nextInt();
        int[] array = creatArray(num);

        Scanner sc2 = new Scanner(System.in);

        out:
        while (true) {
            System.out.println("输入您的猜测数据");
            int guessNum = sc2.nextInt();

            for (int i = 0; i < array.length; i++) {
                if (guessNum == array[i]) {
                    System.out.println("猜测成功！");
                    showArray(array);
                    break out;
                }
            }
            System.out.println("没猜中，请再接再厉");
            System.out.println("---------------");
        }

    }

    static int[] creatArray(int m) {
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = new Random().nextInt(20) + 1;
        }
        return array;
    }
    static void showArray(int array[]){
            System.out.print("实际数组为：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}

