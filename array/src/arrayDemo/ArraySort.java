package arrayDemo;

import java.util.Random;

public class ArraySort {
    public static void main(String[] args) {

        int[] array1 = {4, 5, 6, 8, 7, 1, 3, 2};
        int[] array2 = new int[12];
        for (int i = 0; i < 12; i++) {
            array2[i] = new Random().nextInt(15);

        }

        showArray(array1);
        showArray(array2);

        quickSort(array1,0, array1.length-1);
        quickSort(array2,0, array1.length-1);

        showArray(array1);
        showArray(array2);

    }

    //冒泡排序思想：每轮从数组中找出 *最大值* 放在数组的后面去，重复多轮
    //1.确定总共需要做*几轮*排序：数组内的每个数字都要和其他数字比较，但最后一个数字不需要和和自己进行比较
    // 数组长度-1 (array.length - 1)
    //2.每轮需要比较几次：每轮排序都是当前选定数字与未进行排序的其他数字进行比较，
    // 于是每轮比较次数 = 未进行比较的数字数量 = 数组总长度 - 已比较数字数量 - 1（当前正在比较的数字本身）
    // = 数组总长度 - 当前比较轮次次数 = 数组总长度 - i(current) -1
    // 次数规律： 数组长度-i-1 (array.length - i -1)
    static int[] bubleSort(int array[]) {
        //决定轮数
        for (int i = 0; i < array.length - 1; i++) {
            //决定每轮排序的次数
            for (int j = 0; j < array.length - i - 1; j++) {
                //进行比较
                if (array[j] > array[j + 1]) {
                    //空杯赋值
                    swap(array, j, j+1);
                }
            }
        }
        return array;
    }



    /**
     * 入口函数（递归方法），算法的调用从这里开始。
     */
    static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // 核心算法部分：分别介绍 双边指针（交换法），双边指针（挖坑法），单边指针
        int pivotIndex = doublePointerSwap(arr, startIndex, endIndex);
        // int pivotIndex = doublePointerHole(arr, startIndex, endIndex);
        // int pivotIndex = singlePointer(arr, startIndex, endIndex);

        // 用分界值下标区分出左右区间，进行递归调用
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 双边指针（交换法）
     * 思路：
     * 记录分界值 pivot，创建左右指针（记录下标）。
     * （分界值选择方式有：首元素，随机选取，三数取中法）
     * <p>
     * 首先从右向左找出比pivot小的数据，
     * 然后从左向右找出比pivot大的数据，
     * 左右指针数据交换，进入下次循环。
     * <p>
     * 结束循环后将当前指针数据与分界值互换，
     * 返回当前指针下标（即分界值下标）
     */
    static int doublePointerSwap(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;

        while (leftPoint < rightPoint) {
            // 从右向左找出比pivot小的数据
            while (leftPoint < rightPoint && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            // 从左向右找出比pivot大的数据
            while (leftPoint < rightPoint && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            // 没有过界则交换
            if (leftPoint < rightPoint) {
                swap(arr, leftPoint, rightPoint);
            }
        }
        // 最终将分界值与当前指针数据交换
        swap(arr, startIndex, rightPoint);
        // 返回分界值所在下标
        return rightPoint;
    }

    /**
     * 双边指针（挖坑法）
     * 思路：
     * 创建左右指针。
     * 记录左指针数据为分界值 pivot，
     * 此时左指针视为"坑"，里面的数据可以被覆盖。
     * <p>
     * 首先从右向左找出比pivot小的数据，
     * 找到后立即放入左边坑中，当前位置变为新的"坑"，
     * 然后从左向右找出比pivot大的数据，
     * 找到后立即放入右边坑中，当前位置变为新的"坑"，
     * <p>
     * 结束循环后将最开始存储的分界值放入当前的"坑"中，
     * 返回当前"坑"下标（即分界值下标）
     */
    static int doublePointerHole(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;

        while (leftPoint < rightPoint) {
            // 从右向左找出比pivot小的数据，
            while (leftPoint < rightPoint
                    && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            // 找到后立即放入左边坑中，当前位置变为新的"坑"
            if (leftPoint < rightPoint) {
                arr[leftPoint] = arr[rightPoint];
                leftPoint++;
            }
            // 从左向右找出比pivot大的数据
            while (leftPoint < rightPoint
                    && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            // 找到后立即放入右边坑中，当前位置变为新的"坑"
            if (leftPoint < rightPoint) {
                arr[rightPoint] = arr[leftPoint];
                rightPoint--;
            }
        }
        // 将最开始存储的分界值放入当前的"坑"中
        arr[rightPoint] = pivot;
        return rightPoint;
    }

    /**
     * 单边指针
     * 思路：
     * 记录首元素为分界值 pivot, 创建标记 mark 指针。
     * 循环遍历与分界值对比。
     * 比分界值小，则 mark++ 后与之互换。
     * 结束循环后，将首元素分界值与当前mark互换。
     * 返回 mark 下标为分界值下标。
     */
    static int singlePointer(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int markPoint = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            // 如果比分界值小，则 mark++ 后互换。
            if (arr[i] < pivot) {
                markPoint++;
                int temp = arr[markPoint];
                arr[markPoint] = arr[i];
                arr[i] = temp;
            }
        }
        // 将首元素分界值与当前mark互换
        arr[startIndex] = arr[markPoint];
        arr[markPoint] = pivot;
        return markPoint;
    }

    static void swap(int array[],int x,int y){
        int t = array[x];
        array[x] = array[y];
        array[y] = t;
    }

    static void showArray(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

