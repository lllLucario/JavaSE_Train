package loopDemo;

public class WhileLoop {
    public static void main(String[] args) {
        int i = 0;
        while (i < 2){
            System.out.println("Hello World");
            i++;
        }
        System.out.println(addNum(100));
    }

    static int addNum(int number){
        int i = 0, result = 0;

        while(i < number){
            i++;
            result += i;
        }
    return result;
    }
}