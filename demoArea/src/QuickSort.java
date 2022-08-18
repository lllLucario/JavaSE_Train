import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] array = creatArray();
        showArray(array);

        quickSort(array,0 , array.length -1);
        showArray(array);

    }

    static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        int pivotIndex = sortBody1(array, startIndex, endIndex);

        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    static int sortBody1(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        System.out.println("--------------------------");
        showArray(array);

        while (left < right) {
            while (left < right
                    && array[right] > pivot) {
                right--;
            }
            while (left < right
                    && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(array, right, left);
            }
        }

        //swap(array, right, startIndex);
        array[startIndex] = array[right];
        array[right] = pivot;

        return right;
    }

    static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    static int[] creatArray() {
        int[] array = new int[12];
        for (int i = 0; i < 12; i++) {
            array[i] = new Random().nextInt(20);
        }
        return array;
    }

    static void showArray(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

