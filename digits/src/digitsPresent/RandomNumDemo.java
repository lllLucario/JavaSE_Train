package digitsPresent;

import java.util.Random;

public class RandomNumDemo {
    int inputNum;
    public static void main(String[] args) {
       //生成随机数
        Random r = new Random();
        int randomNum = r.nextInt(100);

        System.out.println(randomNum);
    }
}
