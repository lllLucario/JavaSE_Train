package digitsPresent;

public class GetNumbers {
    public static void main(String[] args) {
        int number = 985;
        System.out.println("原数字：" + number);
        System.out.println("百位数：" + number / 10 / 10 % 10);
        System.out.println("十位数：" + number / 10 % 10);
        System.out.println("个位数：" + number % 10);
    }
}
