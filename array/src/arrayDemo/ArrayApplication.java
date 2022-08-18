package arrayDemo;

public class ArrayApplication {
    public static void main(String[] args) {
        int[] array = {1, 2, 8 ,4, 6, 7};
        System.out.println(sumOfArray(array));
        System.out.println(bubleSort(array));
    }

    static int sumOfArray(int array[]){
        int sum = 0 ;

        for (int i = 0; i < array.length; i++ ){
            sum += array[i];
        }
        return sum;
    }

    static int bubleSort(int array[]){
        int maxNum = 0;
        for (int i = 0; i < array.length; i++){
            if (maxNum < array[i])
                maxNum = array[i];
        }
        return maxNum;
    }
}