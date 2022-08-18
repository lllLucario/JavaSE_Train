package loopDemo;

public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 0;
        do{
            System.out.println("Hello World");
            i++;
        }while(i < 3);
    }
}
// (i = 0) -> (i = 1) -> (i = 2) -> (i = 3) （被打断）
