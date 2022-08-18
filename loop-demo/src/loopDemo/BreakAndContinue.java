package loopDemo;

public class BreakAndContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++ ){
            //当 i=3时，直接终止循环
            if(i == 3)
                break;
            System.out.println(i);
        }

        System.out.println("----------------------------");

        for (int i = 0; i < 5; i++){
            //跳过3，进入下一次循环
            if (i == 3)
                continue;
            System.out.println(i);
        }
    }
}
